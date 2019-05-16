package com.infoshare.alpha.wwr.di;

import java.util.HashMap;

import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsDbRepository;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;

// klasa ktora udostepnia wszystkie funkcjonalnosci aplikacji, serwisy i read modele z jednego miejsca
// DI - dependency injection
public final class AppDI {

    private HashMap<String, DI> di;

    private String facilitiesFilePath;
    private String patientsFilePath;

    public AppDI(String facilitiesFilePath, String patientsFilePath) {

        this.facilitiesFilePath = facilitiesFilePath;
        this.patientsFilePath = patientsFilePath;

        this.di = new HashMap<String, DI>();

        this.initializeDiServices();
    }

    private void initializeDiServices() {

        /*
        -> disable old dependency injection, java ee di used instead.
        -> it will be removed soon.

        FacilitiesJsonStorage facilitiesJsonStorage = new FacilitiesJsonStorage(this.facilitiesFilePath);
        FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository(facilitiesJsonStorage);
        FacilitiesReadModel facilitiesReadModel = new FacilitiesReadModel(facilitiesReadModelDbRepository);
        FacilitiesRepository facilitiesRepository = new FacilitiesDbRepository(facilitiesJsonStorage);
        FacilitiesService facilitiesService = new FacilitiesService(facilitiesRepository, facilitiesReadModelDbRepository);

        this.di.put(FacilitiesJsonStorage.class.getName(), facilitiesJsonStorage);
        this.di.put(FacilitiesReadModelDbRepository.class.getName(), facilitiesReadModelDbRepository);
        this.di.put(FacilitiesReadModel.class.getName(), facilitiesReadModel);
        this.di.put(FacilitiesService.class.getName(), facilitiesService);


        PatientsJsonStorage patientsJsonStorage = new PatientsJsonStorage(this.patientsFilePath);
        PatientsDbRepository patientsDbRepository = new PatientsDbRepository(patientsJsonStorage);
        PatientsReadModelDbRepository patientsDbReadModelRepository = new PatientsReadModelDbRepository(patientsJsonStorage);
        PatientsReadModel patientsReadModel = new PatientsReadModel(patientsDbReadModelRepository);
        PatientsService patientsService = new PatientsService(patientsDbReadModelRepository, patientsDbRepository);

        this.di.put(PatientsJsonStorage.class.getName(), patientsJsonStorage);
        this.di.put(PatientsRepository.class.getName(), patientsDbRepository);
        this.di.put(PatientsReadModelDbRepository.class.getName(), patientsDbReadModelRepository);
        this.di.put(PatientsReadModel.class.getName(), patientsReadModel);
        this.di.put(PatientsService.class.getName(), patientsService);
        */
    }

    public DI getService(String name) {

        if (!this.di.containsKey(name)) {
            // TODO: tutaj nalezy rzucac wyjatek
            System.out.println("Exception : Service " + name + " not found .");
        }

        return (DI) this.di.get(name);
    }

    public void printDIServices() {

        for (String serviceName : this.di.keySet()) {
            System.out.println(serviceName);
        }
    }


}