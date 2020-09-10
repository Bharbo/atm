package ru.sbrf.course.atm.operations.impl;

import ru.sbrf.course.atm.operations.Operations;
import ru.sbrf.course.atm.server.model.Operation;
import ru.sbrf.course.atm.types.OpType;

import java.util.Date;

public class Balance implements Operations {

    @Override
    public Operation createOperation(String accountNumber) {
        Date ms = new Date();
        Date date = new Date(ms.getTime());
        return new Operation(accountNumber, OpType.BALANCE.name(), date);
    }
}
