package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.types.CurrencyType;
import ru.sbrf.course.atm.types.PaymentSystem;
import ru.sbrf.course.atm.types.PrivilegeType;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Card {
    private int id;
    private String number;
    private Date validThrough;
    private String CVC;
    private String PIN;
    private Map<CurrencyType, Account> account;
    private PrivilegeType privilegeType;
    private PaymentSystem paymentSystem;
}
