package ru.sbrf.course.atm.server.service;

import lombok.Getter;
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
@Getter
public class AuthService {

    CardRepository cardRepository;
    AccountRepository accountRepository;
    private Card currentCard;
    private Account currentAccount;

    @Autowired
    public AuthService(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        currentCard = null;
        currentAccount = null;
    }

    public Response checkCard(String cardNumber) {

        Card card = cardRepository.findByNumber(cardNumber);
        //проверка платежной системы
        //Я подразумеваю что банкомат принимает карты со всеми платежными системами кроме "МИР"
        if (card.getPaymentSystem() == PaymentSystem.MIR) {
            return new Response(false, "Платежная система МИР не поддерживается данным банкоматом");
        }
        //проверка наличия карты в бд
        Account account = accountRepository.findByCardNumber(cardNumber);
        if (account == null) {
            return new Response(false, "Отсутствует счет, привязанный к данной карте");
        }
        //проверка статуса счета
        if (account.getAccountStatus().equals(AccountStatus.BLOCKED)) {
            return new Response(false, "Ваша карта заблокирована, где получали туда и обращайтесь)");
        }
        currentCard = card;
        currentAccount = account;
        return new Response(true, "Введите пароль от вашей карты");
    }

    public Response checkPass(String atmPass) {
        if (atmPass.equals(currentCard.getPass())) {
            return new Response(true, "Выберите операцию");
        } else {
            return new Response(false, "Вы ввели некорректный пароль, попробуйте снова");
        }
    }
}