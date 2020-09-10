package ru.sbrf.course.atm.operations.impl;

import org.springframework.stereotype.Component;
import ru.sbrf.course.atm.operations.Operations;
import ru.sbrf.course.atm.server.model.Operation;

public class CashWithdrawal implements Operations {

    @Override
    public Operation createOperation(String accountNumber){
        return new Operation();
    }
}
