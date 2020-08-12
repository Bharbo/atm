package ru.sbrf.course.atm.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sbrf.course.atm.server.Bank;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Atm {

    private Bank bank;//Хост с которым банкомат обменивается данными
    private BigDecimal moneyInside;
}
