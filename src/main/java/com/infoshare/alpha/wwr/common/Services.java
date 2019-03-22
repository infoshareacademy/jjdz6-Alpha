package com.infoshare.alpha.wwr.common;

import java.util.ArrayList;
import java.util.List;

public class Services {

    private List<Service> services = new ArrayList<>();

    public List<Service> getServices() {
        return services;
    }

    public static Services fromList(List<Service> servicesList) {
        Services services = new Services();
        services.setServices(servicesList);
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void add(Service service) {
        this.services.add(service);
    }

    public void printAllServices() {
        for(Service service : this.services) {
            System.out.println(service);
        }
    }

    private String getAllServices() {
        StringBuilder sb = new StringBuilder();
        for(Service service : this.services) {
            sb.append(service.toString());
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "services= { " + this.getAllServices() +
                '}';
    }
}
