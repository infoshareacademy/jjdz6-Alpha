package com.infoshare.alpha.wwr.domain.facilities.command;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

public class FacilityDeleteCommand extends FacilityCommand {

    public FacilityDeleteCommand(Facility facility) {
        super(facility);
    }
}
