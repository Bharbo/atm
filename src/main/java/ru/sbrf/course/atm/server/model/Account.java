package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.AccountType;
import ru.sbrf.course.atm.types.CurrencyType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int id;
    @Column(name = "cardNumber")
    private String number;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "currency_type")
    private CurrencyType currencyType;//убрать, потому что параметр будет в мапе?
    @Column(name = "account_type")
    private AccountType accountType;
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    @Column(name = "bank")
    private Bank bank;//Банк в котором открыт данный счет
    @Column(name = "cards")
    private Set<Card> cards; //к счету не обязательно будет привязана карта или их может быть несколько штук

    //без карты
    public Account(String number, BigDecimal balance, CurrencyType currencyType, AccountType accountType, AccountStatus accountStatus, Bank bank) {
        this.number = number;
        this.balance = balance;
        this.currencyType = currencyType;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.bank = bank;
    }
}
