package ru.sbrf.course.atm.operations;

import ru.sbrf.course.atm.server.model.Operation;

public interface Operations {
    Operation createOperation(String accountNumber);
}
