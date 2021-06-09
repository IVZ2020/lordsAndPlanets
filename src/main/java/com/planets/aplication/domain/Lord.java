package com.planets.aplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lord implements Comparable<Lord> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lordName;
    private long lordAge;
    private Role lordRole;
//    @OneToMany(mappedBy = "lord")
//    private Set<Planet> planets;

    public Lord (String lordName, long lordAge, Role lordRole) {
        this.lordName = lordName;
        this.lordAge = lordAge;
        this.lordRole = lordRole;
    }

    @Override
    public int compareTo(Lord lord) {
        return (int) (lord.lordAge - this.lordAge);
    }
}
