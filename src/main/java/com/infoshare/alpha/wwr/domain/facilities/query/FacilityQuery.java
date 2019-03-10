package com.infoshare.alpha.wwr.domain.facilities.query;

import java.util.Map;

public class FacilityQuery {

    private Map<FacilityQueryField, String> queryFields;


    public FacilityQuery(Map<FacilityQueryField, String> queryFields) {
        this.queryFields = queryFields;
    }

    public Map<FacilityQueryField, String > getQueryFields() {
        return queryFields;
    }

}
