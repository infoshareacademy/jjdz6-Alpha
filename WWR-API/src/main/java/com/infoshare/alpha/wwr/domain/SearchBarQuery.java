package com.infoshare.alpha.wwr.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_bar_queries")
public class SearchBarQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "query_text")
    private String queryText;

    @NotBlank
    @Column(name = "query_origin_url")
    private String queryOriginUrl;

    @CreationTimestamp
    @Column(name = "timestamp")
    private LocalDateTime timestamp;


//    @Column(name = "user")
//    private User user;


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

    public String getQueryOriginUrl() {
        return queryOriginUrl;
    }

    public void setQueryOriginUrl(String queryOriginUrl) {
        this.queryOriginUrl = queryOriginUrl;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
