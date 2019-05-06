package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.common.Facility;

public abstract class FacilityCommand {

    private Facility facility;

    public FacilityCommand(Facility facility) {
        this.facility = facility;
    }

    public FacilityCommand() {

    }

    public Facility getFacility() {
        return facility;
    }

    protected void set(Facility facility) {
        this.facility = facility;
    }
}

