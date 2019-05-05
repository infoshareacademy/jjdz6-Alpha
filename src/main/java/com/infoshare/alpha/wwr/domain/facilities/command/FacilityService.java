package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class FacilityService {

    @EJB
    Facilities facilities;

    public void saveFacility(Facility facility) {
        facilities.add(facility);
    }
}

