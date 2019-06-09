package com.infoshare.alpha.wwr.servlet.validators;

import javax.enterprise.context.RequestScoped;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class PatientServletValidator {
    private final String[] requiredPatientFields = {"name", "surname", "pesel", "street", "city", "phone", "postalCode", "parentName", "parentSurname"};

    public void validatePutRequest(Map<String, String[]> requestData) throws PatientValidationException{
        this.validateRequiredFields(requestData.keySet());
        this.validateName(requestData.get("name")[0]);
        this.validateSurname(requestData.get("surname")[0]);
        this.validatePesel(requestData.get("pesel")[0]);
        this.validateStreet(requestData.get("street")[0]);
        this.validateCity(requestData.get("city")[0]);
        this.validatePhone(requestData.get("phone")[0]);
        this.validatePostal(requestData.get("postalCode")[0]);
        this.validateCaretakerName(requestData.get("parentName")[0]);
        this.validateCaretakerSurname(requestData.get("parentSurname")[0]);

    }

    private void validateRequiredFields(Set<String> keySet) throws PatientValidationException {
        Set<String> requiredKeys = Arrays.stream(this.requiredPatientFields).collect(Collectors.toSet());

        if (!keySet.containsAll(requiredKeys)) {
            throw PatientValidationException.keys();
        }
    }

    private void validateName(String name) throws PatientValidationException {

        if (name == null) {
            throw PatientValidationException.name();
        }

        if (name.isEmpty()) {
            throw PatientValidationException.name();
        }
    }

    private void validateSurname(String surname) throws PatientValidationException {

        if (surname == null) {
            throw PatientValidationException.surname();
        }

        if (surname.isEmpty()) {
            throw PatientValidationException.surname();
        }
    }

    private void validatePesel(String pesel) throws PatientValidationException {

        if (pesel == null) {
            throw PatientValidationException.pesel();
        }

        if (pesel.isEmpty()) {
            throw PatientValidationException.pesel();
        }

        if (pesel.length() != 11) {
            throw PatientValidationException.pesel();
        }
    }

    private void validateStreet(String street) throws PatientValidationException {
        if (street == null) {
            throw PatientValidationException.street();
        }

        if (street.isEmpty()) {
            throw PatientValidationException.street();
        }
    }

    private void validateCity(String city) throws PatientValidationException {
        if (city == null) {
            throw PatientValidationException.city();
        }

        if (city.isEmpty()) {
            throw PatientValidationException.city();
        }
    }

    private void validatePhone(String phone) throws PatientValidationException {
        if (phone == null) {
            throw PatientValidationException.phone();
        }

        if (phone.isEmpty()) {
            throw PatientValidationException.phone();
        }
    }

    private void validatePostal(String postal) throws PatientValidationException {
        if (postal == null) {
            throw PatientValidationException.postal();
        }

        if (postal.equals("")) {
            throw PatientValidationException.postal();
        }

        try {
            Integer.valueOf(postal);
        } catch (NumberFormatException e) {
            throw PatientValidationException.postal();
        }
    }

    private void validateCaretakerName(String parentName) throws PatientValidationException {

        if (parentName == null) {
            throw PatientValidationException.caretakerName();
        }

        if (parentName.isEmpty()) {
            throw PatientValidationException.caretakerName();
        }
    }

    private void validateCaretakerSurname(String parentSurname) throws PatientValidationException {

        if (parentSurname == null) {
            throw PatientValidationException.caretakerSurname();
        }

        if (parentSurname.isEmpty()) {
            throw PatientValidationException.caretakerSurname();
        }
    }
}
