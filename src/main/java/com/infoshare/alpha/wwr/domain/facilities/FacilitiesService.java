package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.UploadCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
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

    public void delete(FacilityDeleteCommand command) throws FacilitiesException {

        // funckcja do usuwania placówki
        // 1. sprawdz czy taka placowka istnieje w kolekcji
        Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
        if(!(facilities.getFacilities().contains(command.getFacility()))){
            // 2. jesli nie itnieje rzuc wyjatek : throw FacilitiesException.facilityNotFound());
            throw FacilitiesException.facilityNotFound(command.getFacility().getName());
            // 3. jesli istnieje to usun z kolekcji
        }else{
            facilities.getFacilities().remove(command.getFacility());
            // 4. zapisz kolekcje do repo
            this.facilitiesDbRepository.persist(facilities);
        }
    }

    public void edit(FacilityEditCommand command) {

        // funkcja do edycji placowki
        // 1. sprawdz czy taka placowka istnieje w kolekcji
        // 2. jesli nie itnieje rzuc wyjatek:
        // 2. jesli nie itnieje rzuc wyjatek :
        // 3. jesli istnieje to podmien w kolekcji
        // 4. zapisz cala kolekcje do repo

    }
    
    public void upload(UploadCommand uploadCommand) {
    	
    	// funkcja ktora wrzuca do repozutorium dodatkowe placowki 
    	// 1. zaciagnij aktualne placowki z repozytorium placowek -> Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
    	// 2. wczytaj placowki z pliku -> wykorzystaj : FacilitiesJsonStorage
    	// 3. po poprawnym wczytaniu zmerguj dwie kolekcje obiektow
    	// 4. zapisz zmergowana kolekcje do repozytorium -> wykorzystaj : this.facilitiesDbRepository.persist(facilities);
    }
}
