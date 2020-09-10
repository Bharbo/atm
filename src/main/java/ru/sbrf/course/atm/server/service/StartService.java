package ru.sbrf.course.atm.server.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.server.model.Card;
import ru.sbrf.course.atm.server.repository.AccountRepository;
import ru.sbrf.course.atm.server.repository.CardRepository;
import ru.sbrf.course.atm.server.support.Response;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.PaymentSystem;

@Service
@Getter
public class StartService {

    CardRepository cardRepository;
    AccountRepository accountRepository;
    private Card currentCard;
    private Account currentAccount;

    @Autowired
    public StartService(CardRepository cardRepository, AccountRepository accountRepository) {
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
            return new Response(false, "\nПлатежная система МИР не поддерживается данным банкоматом\n");
        }
        //проверка наличия карты в бд
        Account account = accountRepository.findByCardNumber(cardNumber);
        if (account == null) {
            return new Response(false, "\nОтсутствует счет, привязанный к данной карте\n");
        }
        //проверка статуса счета
        if (account.getAccountStatus().equals(AccountStatus.BLOCKED)) {
            return new Response(false, "\nВаша карта заблокирована, где получали туда и обращайтесь)\n");
        }
        currentCard = card;
        currentAccount = account;
        return new Response(true, "\nВведите пароль от вашей карты\n");
    }
}