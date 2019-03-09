package com.infoshare.alpha.wwr.facilities.query;

import java.util.List;

public class FacilityQuery {

    private List<FacilityQueryFields> queryFields;

    private String keyword;

    public FacilityQuery(List<FacilityQueryFields> queryFields, String keyword) {
        this.queryFields = queryFields;
        this.keyword = keyword;
    }

    public List<FacilityQueryFields> getQueryField() {
        return queryFields;
    }

    public String getKeyword() {
        return keyword;
    }
}
