package ru.sbrf.course.atm.server.model;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.sbrf.course.atm.types.OpType;

import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operation {
    private int id;
    private Card card;
    private Account account;
    private OpType opType;
    private Date date;

    //операция может пройти и без данных карты
    public Operation(Account account, OpType opType, Date date) {
        this.account = account;
        this.opType = opType;
        this.date = date;
    }

    public Operation(Account account, OpType opType, Date date, Card card) {
        this.account = account;
        this.opType = opType;
        this.date = date;
        this.card = card;
    }
}
