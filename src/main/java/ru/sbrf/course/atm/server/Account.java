package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.AccountType;
import ru.sbrf.course.atm.types.CurrencyType;

@Getter
@Setter
@AllArgsConstructor
//2 LVL
public class Account {
    private int id;
    private String number;//номер счета будет выступать здесь как идентификатор
    private long balance;
    private CurrencyType currencyType;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Bank bank;//Банк в котором открыт данный счет
}
