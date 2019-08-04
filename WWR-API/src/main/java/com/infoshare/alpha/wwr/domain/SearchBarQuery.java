package com.infoshare.alpha.wwr.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Optional;

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

    //TODO domyslnie przesylac "" zamiast null? -> dodac @NotNull
    public Optional<String> getQueryText() {
        return Optional.ofNullable(queryText);
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }
}
