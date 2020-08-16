package ru.sbrf.course.atm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.model.User;
import ru.sbrf.course.atm.server.repository.AccountRepository;
import ru.sbrf.course.atm.server.repository.CardRepository;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.server.model.Card;
import ru.sbrf.course.atm.server.repository.UserRepository;
import ru.sbrf.course.atm.server.support.Session;
import ru.sbrf.course.atm.types.AccountStatus;

import java.util.Base64;
import java.util.Map;

@Service
public class AuthorizationService {

    CardRepository cardRepository;
    AccountRepository accountRepository;

    @Autowired
    public AuthorizationService(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    //getrequest
    public Session isAuthorized(Map<String, String> authData){
        Card currentCard = cardRepository.findByNumber(decoder(authData.get("number")));
        Account currentAccount;
        Session session = null;
        if (currentCard != null){
            String encodedPassInRepo = getPass(currentCard, authData.get("passType"));
            String decodedPassInRepo = decoder(encodedPassInRepo);
            String decodedPassInRequest = decoder(authData.get("pass"));//
            if (decodedPassInRepo.equals(decodedPassInRequest)) {
                currentAccount = accountRepository.findByCard(currentCard);
                if (currentAccount.getAccountStatus() != AccountStatus.ACTIVE)
                    return null;
                session = new Session(currentCard, true);
            }
        }
        return session;
    }

    public String decoder(String encodeData){
        byte[] decodedDataAsBytes = Base64.getDecoder().decode(encodeData);
        return new String(decodedDataAsBytes);
    }


    //В зависимости от типа аутентификации, который сервер получает в запросе от Atm,
    // вытягивается соответствующий пароль из репозитория

    // Я представляю что при любом из выбранных способов аутентификации сервер получает пароль типа String
    // и используется одинаковая кодировка, поэтому этого метода достаточно.
    // В реальности же все наверняка сложнее и понадобились бы классы из директории accessTools.
    public String getPass(Card currentCard, String passType){
        return currentCard.getPass().get(passType);
    }
}
