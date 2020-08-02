package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.external.CurrencyType;
import ru.sbrf.course.atm.external.PrivilegeType;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private int accountNumber;//номер счета будет выступать здесь как идентификатор
    private long balance;
    private CurrencyType currencyType;
    /**
     * Банк в котором открыт данный счет
     */
    private PrivilegeType privilegeTypeLevel;//уровень привелегий юзера
    private Bank bank;
}
