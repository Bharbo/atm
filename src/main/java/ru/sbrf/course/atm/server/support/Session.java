package ru.sbrf.course.atm.server.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sbrf.course.atm.server.model.Card;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    Card currentCard;
    boolean status;
}
