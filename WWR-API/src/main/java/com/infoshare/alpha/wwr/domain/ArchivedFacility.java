package com.infoshare.alpha.wwr.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "archived_facilities")
public class ArchivedFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @NotNull                            //TODO change once Facility is mapped
    @Column(name = "facility_details")
    private String facilityDetails;

    public ArchivedFacility() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getFacilityDetails() {
        return facilityDetails;
    }

    public void setFacilityDetails(String facilityDetails) {
        this.facilityDetails = facilityDetails;
    }
}
