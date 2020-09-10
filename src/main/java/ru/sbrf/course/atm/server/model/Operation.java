package ru.sbrf.course.atm.server.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    @NonNull
    private String number;
    @Column(name = "opType")
    @NonNull
    private String opType;
    @Column(name = "date")
    @NonNull
    private Date date;
}
