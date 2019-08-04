package com.infoshare.alpha.wwr.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "search_bar_queries")
public class SearchBarQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "query_text")
    private String queryText;

//    @Column(name = "user")
//    private User user;

//    @NotNull
//    private TimeStamp timeStamp;

    public SearchBarQuery() {
    }

    public int getId() {
        return id;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }
}
