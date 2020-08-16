package ru.sbrf.course.atm.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.types.CurrencyType;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Client {
    private int id;
    private String firstname;
    private String lastname;
    private String location;
    private Map<CurrencyType, Account> account;
}
