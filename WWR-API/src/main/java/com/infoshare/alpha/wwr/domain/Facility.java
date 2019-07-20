package com.infoshare.alpha.wwr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACILITIES")
public class Facility {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_occurrences")
    private Long numberOfOccurrences;

    public Facility() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getNumberOfOccurrences() {
        return numberOfOccurrences;
    }
}
