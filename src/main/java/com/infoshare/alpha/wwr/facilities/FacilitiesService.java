package com.infoshare.alpha.wwr.facilities;

public class FacilitiesService {

    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository();

    private FacilitiesRepository facilitiesDbRepository = new FacilitiesDbRepository();

    public FacilitiesService() {

    }

    public void add(Facility facility) {
        Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
        facilities.add(facility);
        this.facilitiesReadModelDbRepository.persist();
    }

    public void delete(Facility facility) {

    }

    public void edit(FacilityEditCommand facilityEditCommand) {

    }
}
