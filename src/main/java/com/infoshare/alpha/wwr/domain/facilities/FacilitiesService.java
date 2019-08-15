package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesService {

    @Inject
    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    @Inject
    private FacilitiesRepository facilitiesDbRepository;

    public void add(FacilityAddCommand command) throws FacilitiesException {
        if (facilitiesReadModelDbRepository.getById(command.getFacility().getId()) != null) {
            throw FacilitiesException.facilityExists(command.getFacility().getName());
        }
       facilitiesDbRepository.add(command.getFacility());
    }

    public void delete(FacilityDeleteCommand command) throws FacilitiesException {

        assertFacilityExists(command.getFacility());
        assertFacilityEmpty(command.getFacility());

        facilitiesDbRepository.remove(command.getFacility());
    }

    private void assertFacilityEmpty(Facility facility) throws FacilitiesException {

        if (!facilitiesDbRepository.containsPatients(facility.getId())) {
            throw FacilitiesException.facilityContainsPatients(facility.getName());
        }

    }

    private void assertFacilityExists(Facility facility) throws FacilitiesException {

        if (!facilitiesReadModelDbRepository.getById(facility.getId()).isPresent()) {
            throw FacilitiesException.facilityNotFound(facility.getName());
        }

    }

    public void edit(FacilityEditCommand command) throws FacilitiesException {
        try {
            checkFacilityExists(command.getFacility());
            facilitiesDbRepository.update(command.getFacility());
        } catch (FacilitiesException e) {
            throw FacilitiesException.editError(e.getMessage());
        }
    }

    private void checkFacilityExists(Facility facility) throws FacilitiesException {
        facilitiesDbRepository.getById(facility.getId());
    }
}
