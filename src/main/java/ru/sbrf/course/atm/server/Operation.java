package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sbrf.course.atm.types.OpType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
    private int id;
    private Account account;
    private OpType opType;
    private Date date;

    public Operation getOperation(){

    }
}
