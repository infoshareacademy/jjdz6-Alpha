package com.infoshare.alpha.wwr.facilities.readModel;

import java.util.List;

import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.entity.Facility;

public interface FacilitiesReadModelDb {

    public Facilities getAll();

    public List<Facility> getByName(String name);

    public List<Facility> getByCity(String city);

}
