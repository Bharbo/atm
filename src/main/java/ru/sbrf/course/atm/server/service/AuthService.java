package ru.sbrf.course.atm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.repository.AccountRepository;
import ru.sbrf.course.atm.server.repository.CardRepository;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.server.model.Card;
import ru.sbrf.course.atm.server.support.Response;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.PaymentSystem;

@Service
public class AuthService {

    CardRepository cardRepository;
    AccountRepository accountRepository;
    Card currentCard;

    @Autowired
    public AuthService(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        currentCard = null;
    }

    public Response checkCard(String cardNumber) {

        Card card = cardRepository.findByNumber(cardNumber);
        //проверка платежной системы
        //Я подразумеваю что банкомат принимает карты со всеми платежными системами кроме "МИР"
        if (card.getPaymentSystem() == PaymentSystem.MIR){
            return new Response(false, "Платежная система МИР не поддерживается данным банкоматом");
        }
        //проверка наличия карты в бд
        Account account = accountRepository.findByCardNumber(cardNumber);
        if (account == null){
            return new Response(false, "Отсутствует счет, привязанный к данной карте");
        }
        //проверка статуса счета
        if (account.getAccountStatus().equals(AccountStatus.BLOCKED)){
            return new Response(false, "Ваша карта заблокирована, где получали туда и обращайтесь)");
        }
        currentCard = card;
        return new Response(true, "Введите пароль от вашей карты");
    }

    public Response checkPass(String atmPass) {
        if (atmPass.equals(currentCard.getPass())){
            return new Response(true, "Выберите операцию");
        } else {
            return new Response(false, "Вы ввели некорректный пароль, попробуйте снова");
        }
    }
    
    
//    //getrequest
//    public Session isAuthorized(Map<String, String> authData){//с банкомата приходит номер счета и пароль
//        Card currentCard = cardRepository.findByNumber(authData.get("number"));
//        Account currentAccount;
//        Session session = null;
//        if (currentCard != null){
//            String passInDB = currentCard.getPass();//пароль из бд
//            String passFromAtm = authData.get("pass");//получаем пароль с банкомата
//            if (passInDB.equals(passFromAtm)) {//сравниваем пароли
//                currentAccount = accountRepository.findByCard(currentCard);
//                if (currentAccount.getAccountStatus() != AccountStatus.ACTIVE)
//                    return null;
//                session = new Session(currentCard, true);
//            }
//        }
//        return session;
//    }

}







//    public String decoder(String encodeData){
//        byte[] decodedDataAsBytes = Base64.getDecoder().decode(encodeData);
//        return new String(decodedDataAsBytes);
//    }


//В зависимости от типа аутентификации, который сервер получает в запросе от Atm,
// вытягивается соответствующий пароль из репозитория

// Я представляю что при любом из выбранных способов аутентификации сервер получает пароль типа String
// и используется одинаковая кодировка, поэтому этого метода достаточно.
// В реальности же все наверняка сложнее и понадобились бы классы из директории accessTools.
//    public String getPass(Card currentCard, String passType){//получаем пароль в зависимости от способа
//        return currentCard.getPass().get(passType);
//    }