package ru.sbrf.course.atm.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sbrf.course.atm.client.model.Client;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    private int id;
    private String name;
    private String location;
    private String numberOfCorrespondentAccount;
    private String BIK;
    private String KPP;
    private String INN;
    private Set<Client> clients;

    public long getBalance(long clientNumber, String accountNumber){

        //1ый уровень абстракции

        //1.Валидация запроса
        validate();
        //2.сохранение переменных
        save();
        //3. получение счета
        getAccount();
    }

    private void getAccount() {
//        второй уровень абстракции
//      1.метод1
//      2.метод2
//      3.метод3
    }
}
