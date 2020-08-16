package ru.sbrf.course.atm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.server.model.Operation;
import ru.sbrf.course.atm.server.repository.OperationRepository;
import ru.sbrf.course.atm.types.OpType;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OperationService {

    OperationRepository opRep;

    @Autowired
    public OperationService(OperationRepository opRep) {
        this.opRep = opRep;
    }

    //будет вызываться из контроллера после вызова AuthorizationService.isAuthorized
    public BigDecimal balanceRequestWithCard(Operation op) {

        opRep.save(op);
        return op.getAccount().getBalance();
    }
}