package com.infoshare.alpha.wwr.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "is_nfz")
    private Boolean isNfz;

//    @Column(name = "number_of_occurrences")
//    private Long numberOfOccurrences;

    public Facility() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNfz() {
        return isNfz;
    }

    public void setNfz(Boolean nfz) {
        isNfz = nfz;
    }
}
