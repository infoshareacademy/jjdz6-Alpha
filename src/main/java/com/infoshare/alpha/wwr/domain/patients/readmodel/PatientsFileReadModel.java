package com.infoshare.alpha.wwr.domain.patients.readmodel;

//import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.di.DI;
//import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
//import com.infoshare.alpha.wwr.domain.patients.query.PatientFacilityQuery;
//import com.infoshare.alpha.wwr.domain.patients.query.PatientFacilityQueryFields;
//import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

//import java.util.ArrayList;
//import java.util.List;

public class PatientsFileReadModel implements DI {

//    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

//    private PatientsReadModelDbRepository patientsRepository;

//    public PatientsFileReadModel(FacilitiesReadModelDbRepository institutionsRepository, PatientsReadModelDbRepository patientsRepository) {
//        this.facilitiesReadModelDbRepository = institutionsRepository;
//        this.patientsRepository = patientsRepository;
//    }
// TODO: move to Facilities Read Model
//    @Override
//    
//    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient) {
//
//        return this.facilitiesReadModelDbRepository.getByCity(patient.getAddress().getCity());
//    }
//
//    @Override
//    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query) {
//
//        List<Facility> facilitiesCollection;
//
//        PatientFacilityQueryFields field = query.getQueryFields();
//
//        switch (field) {
//            case CITY:
//                facilitiesCollection = this.facilitiesReadModelDbRepository.getByCity(query.getKeyword());
//                break;
//            case FACILITY_NAME:
//                facilitiesCollection = this.facilitiesReadModelDbRepository.getByName(query.getKeyword());
//                break;
//            default:
//                facilitiesCollection = new ArrayList<>();
//        }
//
//        return facilitiesCollection;
//    }
}
