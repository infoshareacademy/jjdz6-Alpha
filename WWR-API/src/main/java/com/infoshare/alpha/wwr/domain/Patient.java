package com.infoshare.alpha.wwr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENTS")
public class Patient {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
