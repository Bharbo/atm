package ru.sbrf.course.atm.server.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.client.model.Client;
import ru.sbrf.course.atm.server.Account;
import ru.sbrf.course.atm.server.Operation;
import ru.sbrf.course.atm.types.OpType;

@Getter
@Setter
@AllArgsConstructor
public class OperationImpl implements Operation {
    private int id;
    private OpType opType;
    private Client client;
    private Account account;


}
