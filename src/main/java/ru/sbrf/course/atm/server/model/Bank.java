package ru.sbrf.course.atm.server.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NonNull
    private String name;
    @Column(name = "location")
    @NonNull
    private String location;
    @Column(name = "corr_number")
    @NonNull
    private String CorrNumber;
    @Column(name = "bik")
    @NonNull
    private String BIK;
    @Column(name = "kpp")
    @NonNull
    private String KPP;
    @Column(name = "inn")
    @NonNull
    private String INN;
}
