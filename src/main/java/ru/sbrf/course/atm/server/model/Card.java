package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.CurrencyType;
import ru.sbrf.course.atm.types.PaymentSystem;
import ru.sbrf.course.atm.types.PrivilegeType;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card {
    private long id;
    private String number;
    private Date validThrough;
    private String cvc;
    private Map<String, String> pass; //<Тип получения доступа, Пароль>
    private Map<CurrencyType, Account> account;
    private PrivilegeType privilegeType;
    private PaymentSystem paymentSystem;

    public Card(String number, Date validThrough, String cvc, Map<String, String> pass, Map<CurrencyType, Account> account, PrivilegeType privilegeType, PaymentSystem paymentSystem) {
        this.number = number;
        this.validThrough = validThrough;
        this.cvc = cvc;
        this.pass = pass;
        this.account = account;
        this.privilegeType = privilegeType;
        this.paymentSystem = paymentSystem;
    }
}
