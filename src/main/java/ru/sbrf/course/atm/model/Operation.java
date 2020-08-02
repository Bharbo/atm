package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.external.OpType;

@Getter
@Setter
@AllArgsConstructor
public class Operation {
    private int id;
    private OpType opType;
    private Client client;
    private Account account;
}
