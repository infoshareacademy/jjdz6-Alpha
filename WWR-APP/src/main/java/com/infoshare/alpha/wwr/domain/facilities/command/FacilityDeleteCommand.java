package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.entities.Facility;

public class FacilityDeleteCommand extends FacilityCommand {

    public FacilityDeleteCommand(Facility facility) {
        super(facility);
    }
}
