package com.infoshare.alpha.wwr;

import java.util.List;

public class PatientsRepository {

    // patients repo, hold collection of Patients from file

    private List<Patient> patients;

    private String repoFilePath;


    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void setRepoFilePath(String repoFilePath) {
        this.repoFilePath = repoFilePath;
    }

    public String getRepoFilePath() {
        return repoFilePath;
    }
}
