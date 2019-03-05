package com.infoshare.alpha.wwr.facilities.readModel;

import com.infoshare.alpha.wwr.facilities.dataStorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.facilities.entity.Facility;

import java.util.List;
import java.util.stream.Collectors;

public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb, DI {

    private Facilities facilities;
    private FacilitiesJsonStorage storage;

    public FacilitiesReadModelDbRepository(FacilitiesJsonStorage storage) {
        try {
            this.storage = storage;
            this.facilities = this.storage.loadResources();
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
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

}
