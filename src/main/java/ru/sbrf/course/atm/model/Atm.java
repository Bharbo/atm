package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Atm {

    private Bank bank;//Хост с которым банкомат обменивается данными
    private BigDecimal moneyInside;
}
