package com.infoshare.alpha.wwr.domain.patients.service;

import com.infoshare.alpha.wwr.domain.patients.dao.PatientsRepositoryDao;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQueryFields;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequestScoped
public class PatientsService {

    @Inject
    private PatientsRepositoryDao patientsRepositoryDao;

    public void add(Patient patient) {

        Patients patients = this.patientsRepositoryDao.getAll();

        patients.add(patient);

        this.patientsRepositoryDao.persist(patients);

        System.out.println(patient.toString() + " added. ");
    }

    public Patients getAll() {

        return patientsRepositoryDao.getAll();
    }

    public Patients getByQuery(PatientQuery patientQuery) {

        List<Patient> filteredPatients = (this.patientsRepositoryDao.getAll().getPatients());

        Map<PatientQueryFields, String> queryFields = patientQuery.getQueryField();

        if (queryFields.containsKey(PatientQueryFields.NAME)) {
            String filterName = queryFields.get(PatientQueryFields.NAME);
            Stream<Patient> stream = filteredPatients.stream().filter(s -> filterName.equals(s.getName()));
            filteredPatients = (List<Patient>) stream.collect(Collectors.toList());
        }


        if (queryFields.containsKey(PatientQueryFields.SURNAME)) {
            //TODO: to implement
        }

        if (queryFields.containsKey(PatientQueryFields.PESEL)) {
            //TODO: to implement
        }

        if (queryFields.containsKey(PatientQueryFields.CITY)) {
            //TODO: to implement
        }


        if (queryFields.containsKey(PatientQueryFields.STREET)) {
            //TODO: to implement
        }


        if (queryFields.containsKey(PatientQueryFields.PHONE)) {
            //TODO: to implement
        }

        Patients patients = new Patients();
        patients.setPatients(filteredPatients);

        return patients;
    }

    public void edit(Patient patient) {
        // TODO: to implement
    }

    public void delete(Patient patient) {
        //TODO: to implement
    }

    public void load(String filePath) {
        // TODO: to implement
    }


}
