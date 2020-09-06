package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.PaymentSystem;
import ru.sbrf.course.atm.types.PrivilegeType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    private long id;
    private String number;
    private Date validThrough;//дата окончания срока действия
    private String cvc;
    private String pass;
    private PrivilegeType privilegeType;
    private PaymentSystem paymentSystem;

    public Card(String number, Date validThrough, String cvc, String pass, PrivilegeType privilegeType, PaymentSystem paymentSystem) {
        this.number = number;
        this.validThrough = validThrough;
        this.cvc = cvc;
        this.pass = pass;
        this.privilegeType = privilegeType;
        this.paymentSystem = paymentSystem;
    }
}
