package ru.sbrf.course.atm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.operations.Balance;
import ru.sbrf.course.atm.operations.Operations;
import ru.sbrf.course.atm.server.repository.OperationRepository;

import java.math.BigDecimal;

@Service
public class OperationService {

    OperationRepository opRep;

    @Autowired
    public OperationService(OperationRepository opRep) {
        this.opRep = opRep;
    }

//для контроллера
    public BigDecimal balanceRequest(String operationType) {
        Operations op = new Balance().createOperation();
        opRep.save(op);
        return op.createOperation().
    }
}