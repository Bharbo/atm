package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.PaymentSystem;
import ru.sbrf.course.atm.types.PrivilegeType;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    @NonNull
    private String number;
    @Column(name = "validThrough")
    @NonNull
    private Date validThrough;//дата окончания срока действия
    @Column(name = "cvc")
    @NonNull
    private String cvc;
    @Column(name = "pass")
    @NonNull
    private String pass;
    @Column(name = "privilegeType")
    @NonNull
    private PrivilegeType privilegeType;
    @Column(name = "payment_system")
    @NonNull
    private PaymentSystem paymentSystem;
}
