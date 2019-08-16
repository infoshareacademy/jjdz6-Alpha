package com.infoshare.alpha.wwr.domain;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "facilities")
public class FacilityDetailsArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @NotNull
    @Column(name = "archived_facility_details")
    private Facility archivedFacility;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "current_facility_id")
    private Facility currentFacility;

    public FacilityDetailsArchive() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Facility getArchivedFacility() {
        return archivedFacility;
    }

    public void setArchivedFacility(Facility archivedFacility) {
        this.archivedFacility = archivedFacility;
    }

    public Facility getCurrentFacility() {
        return currentFacility;
    }

    public void setCurrentFacility(Facility currentFacility) {
        this.currentFacility = currentFacility;
    }
}
