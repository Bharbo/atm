package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.AccountStatus;
import ru.sbrf.course.atm.types.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    @NonNull
    private String number;
    @Column(name = "balance")
    @NonNull
    private BigDecimal balance;
    @Column(name = "account_type")
    @NonNull
    private AccountType accountType;
    @Column(name = "account_status")
    @NonNull
    private AccountStatus accountStatus;
//    @Column(name = "bank")
//    @NonNull
//    private Bank bank;//Банк в котором открыт данный счет
    @Column(name = "card_number")
    @NonNull
    private String cardNumber;
}
