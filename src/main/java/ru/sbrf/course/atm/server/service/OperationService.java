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
    AuthService authService;

    @Autowired
    public OperationService(OperationRepository opRep, AuthService authService) {
        this.opRep = opRep;
        this.authService = authService;
    }

    public BigDecimal balanceRequest() {
        if (authService.getCurrentAccount() == null) {
            return null;
        }
        Operation op = new Balance().createOperation(authService.getCurrentAccount().getNumber());;
            opRep.save(op);
        return authService.getCurrentAccount().getBalance();
    }
}
