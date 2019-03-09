package com.infoshare.alpha.wwr.facilities.command;

import com.infoshare.alpha.wwr.facilities.entity.Facility;

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

