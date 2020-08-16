package ru.sbrf.course.atm.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.server.model.Bank;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Atm {
    private Bank bank;//Хост с которым банкомат обменивается данными(банкомат привязан к конкретному банку или выбирает его взависимости от запроса?)
    private BigDecimal moneyInside;

}
