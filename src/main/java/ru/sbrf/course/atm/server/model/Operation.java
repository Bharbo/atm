package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.OpType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "operations")
public class Operation {
    private int id;
    private Account account;
    private OpType opType;
    private Date date;

    public Operation(Account account, OpType opType, Date date) {
        this.account = account;
        this.opType = opType;
        this.date = date;
    }
}
