package com.infoshare.alpha.wwr.facilities;

import com.infoshare.alpha.wwr.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.di.DI;

public class FacilitiesService implements DI{

    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;
    private FacilitiesRepository facilitiesDbRepository;

    public FacilitiesService(
    		FacilitiesRepository facilitiesDbRepository,
    		FacilitiesReadModelDbRepository facilitiesReadModelDbRepository
    		) {
    		this.facilitiesDbRepository = facilitiesDbRepository;
    		this.facilitiesReadModelDbRepository = facilitiesReadModelDbRepository;   		
    }

    public void add(FacilityAddCommand command) throws FacilitiesException {

        Facilities facilities = this.facilitiesReadModelDbRepository.getAll();

        if (facilities.getFacilities().contains(command.getFacility())) {

            throw FacilitiesException.facilityExists(command.getFacility().getName());
        }

        facilities.add(command.getFacility());
        this.facilitiesDbRepository.persist(facilities);
    }

    public void delete(FacilityDeleteCommand command) {

        // funckcja do usuwania placówki
        // 1. sprawdz czy taka placowka istnieje w kolekcji
        // 2. jesli nie itnieje rzuc wyjatek : throw FacilitiesException.facilityNotFound());
        // 3. jesli istnieje to usun z kolekcji
        // 4. zapisz kolekcje do repo

    }

    public void edit(FacilityEditCommand command) {

        // funkcja do edycji placowki
        // 1. sprawdz czy taka placowka istnieje w kolekcji
        // 2. jesli nie itnieje rzuc wyjatek:
        // 2. jesli nie itnieje rzuc wyjatek :
        // 3. jesli istnieje to podmien w kolekcji
        // 4. zapisz cala kolekcje do repo

    }
}
