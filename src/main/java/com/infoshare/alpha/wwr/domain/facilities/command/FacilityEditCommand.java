package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.common.Facility;

public class FacilityEditCommand {

    // klasa edit command ktora bedzie uzywana przez metode serwisu zmieniajaca wpis dot. poj. placowki

    private Facility oldFacility;
    private Facility editedFacility;

    public FacilityEditCommand(Facility oldFacility, Facility editedFacility) {
        this.oldFacility = oldFacility;
        this.editedFacility = editedFacility;
    }

    public Facility getOldFacility() {
        return oldFacility;
    }

    public Facility getEditedFacility() {
        return editedFacility;
    }
}
