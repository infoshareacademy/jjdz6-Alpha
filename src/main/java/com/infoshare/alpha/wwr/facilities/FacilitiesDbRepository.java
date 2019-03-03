package com.infoshare.alpha.wwr.facilities;

public class FacilitiesDbRepository implements FacilitiesRepository {

    public FacilitiesDbRepository(){
    }

    public void persist(Facilities facilities) {
        FacilitiesJsonStorage.write(facilities);
    }
}
