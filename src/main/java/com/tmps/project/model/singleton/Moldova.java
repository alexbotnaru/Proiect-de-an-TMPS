package com.tmps.project.model.singleton;

import com.tmps.project.model.Country;

public class Moldova extends Country {
    private static Moldova INSTANCE;

    private Moldova(String name, String currency){
        super(name, currency);
    }

    public static Moldova getInstance(){
        if (INSTANCE == null) INSTANCE = new Moldova("Republic of Moldova", "MDL");

        return INSTANCE;
    }

}
