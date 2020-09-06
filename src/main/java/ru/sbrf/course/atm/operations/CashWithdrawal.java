package ru.sbrf.course.atm.operations;

import ru.sbrf.course.atm.server.model.Operation;

public class CashWithdrawal implements Operations {

    @Override
    public Operation createOperation(){
        return new Operation();
    }
}
