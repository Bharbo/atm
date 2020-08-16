package ru.sbrf.course.atm.server.model;

import lombok.*;
import ru.sbrf.course.atm.types.CurrencyType;
import ru.sbrf.course.atm.types.Role;

import javax.persistence.Entity;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private Role role;
    private Map<CurrencyType, Account> accounts;

    public User(String firstname, String lastname, Role role, Map<CurrencyType, Account> accounts) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.accounts = accounts;
    }
}
