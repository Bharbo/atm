package ru.sbrf.course.atm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.operations.impl.Balance;
import ru.sbrf.course.atm.server.model.Operation;
import ru.sbrf.course.atm.server.repository.OperationRepository;

import java.math.BigDecimal;

@Service
public class OperationService {

    OperationRepository opRep;
    StartService startService;

    @Autowired
    public OperationService(OperationRepository opRep, StartService startService) {
        this.opRep = opRep;
        this.startService = startService;
    }

    public BigDecimal balanceRequest() {
        if (startService.getCurrentAccount() == null) {
            return null;
        }
        Operation op = new Balance().createOperation(startService.getCurrentAccount().getNumber());
        opRep.save(op);
        return startService.getCurrentAccount().getBalance();
    }
}
