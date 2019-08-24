package com.infoshare.alpha.wwr.domain.patients.query;

import java.util.Map;

public class PatientQuery {

    private Map<PatientQueryFields, String> queryFields;

    public PatientQuery(Map<PatientQueryFields, String> queryFields) {
        this.queryFields = queryFields;
    }

    public Map<PatientQueryFields, String> getQueryField() {

        return queryFields;
    }
}
