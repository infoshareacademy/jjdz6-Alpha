package com.infoshare.alpha.wwr.facilities;

import java.util.List;
import java.util.stream.Collectors;

public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb{

    private Facilities facilities;

    public FacilitiesReadModelDbRepository(){

        this.facilities = FacilitiesJsonStorage.load();
    }

    public Facilities getAll() {

        return this.facilities;
    }

    public List<Facility> getByName(String name) {

        return this.facilities.getFacilities().
                stream().
                filter(s->name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    public List<Facility> getByCity(String city) {

        return this.facilities.getFacilities().
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }

    // extract to FacilitiesDbRepository
    public void persist() {
        FacilitiesJsonStorage.write(this.facilities);
    }
}
