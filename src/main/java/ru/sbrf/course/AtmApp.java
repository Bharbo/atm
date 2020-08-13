package ru.sbrf.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sbrf.course.atm.server.Account;
import ru.sbrf.course.atm.server.Card;
import ru.sbrf.course.atm.server.Session;
import ru.sbrf.course.atm.types.CurrencyType;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AtmApp {

	public static void main(String[] args) {
		SpringApplication.run(AtmApp.class, args);
	}
}

//public class AtmApp {
//    public static void main(String[] args) {
//
//        Map<CurrencyType, Account> accounts = new HashMap<>();
//        accounts.put(CurrencyType.RUR, new Account());
//        accounts.put(CurrencyType.USD, new Account());
//
//        Session session = new Session()
//    }
//}
