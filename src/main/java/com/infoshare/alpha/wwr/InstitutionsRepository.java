package com.infoshare.alpha.wwr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstitutionsRepository {

    private List<Institution> institutions;

    public InstitutionsRepository() {
        this.institutions = new ArrayList<>();
        this.institutions.add(new Institution("WWR1", new Address("Gdańsk", "Nowe Ogroady 23", "+48 564 123 123")));
        this.institutions.add(new Institution("WWR2", new Address("Gdańsk", "Al. Gruwaldzka 223", "+48 564 123 555")));
        this.institutions.add(new Institution("WWR3", new Address("Sopot", "Zwyciestwa 17", "+48 754 123 123")));
        this.institutions.add(new Institution("WWR4", new Address("Gdynia", "Kolejowa 23", "+48 112 123 123")));
        this.institutions.add(new Institution("WWR5", new Address("Gdynia", "Swietojanska 110", "+48 456 123 123")));
    }

    public List<Institution> findByCity(String city) {

        return this.institutions.
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }

    public List<Institution> findAll() {

        return this.institutions;
    }
    
    
}
