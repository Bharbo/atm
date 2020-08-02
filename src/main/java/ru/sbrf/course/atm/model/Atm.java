package ru.sbrf.course.atm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Atm {
    /**
     * Хост с которым банкомат обменивается данными
     */
    private Bank bank;
    private BigDecimal moneyInside;
}
