package com.infoshare.alpha.wwr.common;

public class Service {

    private String name;

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return " " +
                "service name: '" + name + '\'' +
                " ";
    }
}
