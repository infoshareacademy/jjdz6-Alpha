package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
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
public class PatientsReadModelDbRepository implements PatientsReadModelDb {

	@Inject
	private PatientsJsonStorage storage;
	
//	public PatientsReadModelDbRepository(PatientsJsonStorage storage) {
//        try {
//            this.storage = storage;
//        } catch (NullPointerException e) {
//            System.out.println(e.toString());
//            e.printStackTrace();
//        }
//	}
	
	public Patients getAll() {
		
		return this.storage.load();
	}
	
	public Patients getByQuery(PatientQuery patientQuery) {

		List<Patient> filteredPatients = (this.storage.load()).getPatients();
		
		Map<PatientQueryFields, String> queryFields = patientQuery.getQueryField();
		
		if (queryFields.containsKey(PatientQueryFields.NAME)) {
			String filterName = queryFields.get(PatientQueryFields.NAME);
			Stream<Patient> stream  = filteredPatients.stream().filter(s->filterName.equals(s.getName()));
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
}
