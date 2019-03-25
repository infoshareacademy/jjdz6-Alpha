package com.infoshare.alpha;

import static com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage.deserializeFacility;
import static com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage.serializeFacility;

public class App {
    public static void main(String[] args) {

        serializeFacility();
        deserializeFacility();

    }
}

