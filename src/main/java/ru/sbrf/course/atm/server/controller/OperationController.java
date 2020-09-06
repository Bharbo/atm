package ru.sbrf.course.atm.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.course.atm.server.repository.AccountRepository;
import ru.sbrf.course.atm.server.service.OperationService;
import ru.sbrf.course.atm.server.service.SessionService;
import ru.sbrf.course.atm.server.support.Response;

@RestController
@RequestMapping("operation")
public class OperationController {

    SessionService sessionService;
    OperationService operationService;
    AccountRepository accountRepository;

//    @PostMapping("/{accountId}/balance")
//    public BigDecimal getBalance(@PathVariable Long accountId, @RequestBody Map<String, String> authData) {
//        sessionService.getSession(authData);
//        Date date = new Date(2048, Calendar.SEPTEMBER, 16, 22, 59, 59);
//        Account account = accountRepository.findById(accountId).orElse(null);
//        Operation operation = new Operation(account, OpType.BALANCE, date);
//        operationService.balanceRequest(operation);
//    }

    @PostMapping("/balance")//account number, response = (status, сумма на счете)
    public ResponseEntity<Object> runOperation(@RequestBody String operationType) {
        Response response = operationService.balanceRequest(operationType);
        return response.isStatus() ?
                new ResponseEntity<>(response.getAddition().toString(), HttpStatus.OK) :
                new ResponseEntity<>(response.getAddition().toString(), HttpStatus.CREATED);
    }

}
