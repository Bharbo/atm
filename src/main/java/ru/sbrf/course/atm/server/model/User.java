package ru.sbrf.course.atm.server.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    @NonNull
    private String firstname;
    @Column(name = "lastname")
    @NonNull
    private String lastname;
    @Column(name = "role")
    @NonNull
    private String role;

//    private Role role;

//    @Column(name = "accounts")
//    @NonNull
//    private Map<CurrencyType, Account> accounts;
}
