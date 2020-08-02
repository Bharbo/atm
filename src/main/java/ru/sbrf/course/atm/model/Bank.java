package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Bank {
    private String name;
    private String location;
    private String correspondentAccount;
    private String BIK;
    private String KPP;
    private String INN;

}
