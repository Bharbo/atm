package ru.sbrf.course.atm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.course.atm.repository.AccountRepository;
import ru.sbrf.course.atm.repository.CardRepository;
import ru.sbrf.course.atm.types.AccountStatus;

@Component
public class Authorization {

    CardRepository cardRepository;
    AccountRepository accountRepository;

    @Autowired
    public Authorization(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    public Account isAuthorized(String cardNumber, String pin){
        Card processCard = cardRepository.findByNumber(cardNumber);
        Account processAccount = null;
        if (processCard != null && processCard.getPIN().equals(pin)) {
            processAccount = accountRepository.findByCard(processCard);
            if (processAccount.getAccountStatus() != AccountStatus.ACTIVE)
                return null;
        }
        return processAccount;
    }
}
