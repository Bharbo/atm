package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.AccountType;
import ru.sbrf.course.atm.types.CurrencyType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//2 LVL
public class Account {
    private int id;
    private String number;//номер счета будет выступать здесь как идентификатор
    private long balance;
    private CurrencyType currencyType;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private Bank bank;//Банк в котором открыт данный счет
    private Card card; //к счету не обязательно будет привязана карта

    //без карты
    public Account(int id, String number, long balance, CurrencyType currencyType, AccountType accountType, AccountStatus accountStatus, Bank bank) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.currencyType = currencyType;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.bank = bank;
    }
}
