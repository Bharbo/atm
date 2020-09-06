package ru.sbrf.course.atm.server.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {
    private int id;
    private String name;
    private String location;
    private String numberOfCorrespondentAccount;
    private String BIK;
    private String KPP;
    private String INN;
    private Set<User> users;

    public Bank(String name, String location, String numberOfCorrespondentAccount, String BIK, String KPP, String INN, Set<User> users) {
        this.name = name;
        this.location = location;
        this.numberOfCorrespondentAccount = numberOfCorrespondentAccount;
        this.BIK = BIK;
        this.KPP = KPP;
        this.INN = INN;
        this.users = users;
    }
}
