package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int id;
    @Column(name = "account_number")
    private String number;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "account_type")
    private AccountType accountType;
    @Column(name = "account_status")
    private AccountStatus accountStatus;
    @Column(name = "bank")
    private Bank bank;//Банк в котором открыт данный счет
    @Column(name = "card_number")
    private String cardNumber;
//        @Column(name = "card")
//    private Card card;


    public Account(String number, BigDecimal balance, AccountType accountType, AccountStatus accountStatus, Bank bank, String cardNumber) {
//    public Account(String number, BigDecimal balance, AccountType accountType, AccountStatus accountStatus, Bank bank, Card card) {
        this.number = number;
        this.balance = balance;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.bank = bank;
        this.cardNumber = cardNumber;
//        this.card = card;
    }
}
