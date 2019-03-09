package com.infoshare.alpha.wwr.facilities.query;

import java.util.List;

public class FacilityQuery {

    private List<FacilityQueryField> queryFields;

    private String keyword;

    public FacilityQuery(List<FacilityQueryField> queryFields, String keyword) {
        this.queryFields = queryFields;
        this.keyword = keyword;
    }

    public List<FacilityQueryField> getQueryFields() {
        return queryFields;
    }

    public String getKeyword() {
        return keyword;
    }
}
