package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.common.Facilities;

public interface FacilitiesReadModelDb {

    void persist(Facilities facilities);

    Facilities getAll();

}
