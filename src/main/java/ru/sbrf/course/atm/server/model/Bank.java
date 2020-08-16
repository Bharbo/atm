package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.client.model.Client;

import javax.persistence.Entity;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bank {
    private int id;
    private String name;
    private String location;
    private String numberOfCorrespondentAccount;
    private String BIK;
    private String KPP;
    private String INN;
    private Set<Client> clients;

    public Bank(String name, String location, String numberOfCorrespondentAccount, String BIK, String KPP, String INN, Set<Client> clients) {
        this.name = name;
        this.location = location;
        this.numberOfCorrespondentAccount = numberOfCorrespondentAccount;
        this.BIK = BIK;
        this.KPP = KPP;
        this.INN = INN;
        this.clients = clients;
    }
}
