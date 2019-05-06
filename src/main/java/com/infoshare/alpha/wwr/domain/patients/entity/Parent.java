package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.User;

public class Parent extends User {


    public Parent(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return " Parent name: " + this.getName() +" ,Parent surname: " + this.getSurname();
    }



}
