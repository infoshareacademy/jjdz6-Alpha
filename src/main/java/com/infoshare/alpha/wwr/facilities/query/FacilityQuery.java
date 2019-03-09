package com.infoshare.alpha.wwr.facilities.query;

public class FacilityQuery {

    private FacilityQueryFields queryField;

    private String keyword;

    public FacilityQuery(FacilityQueryFields queryField, String keyword) {
        this.queryField = queryField;
        this.keyword = keyword;
    }

    public FacilityQueryFields getQueryField() {
        return queryField;
    }

    public String getKeyword() {
        return keyword;
    }
}
