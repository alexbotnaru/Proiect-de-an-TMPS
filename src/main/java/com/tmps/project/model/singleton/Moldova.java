package com.tmps.project.model.singleton;

import com.tmps.project.model.Country;

public class Moldova extends Country {
    private static Moldova INSTANCE;

    private Moldova(Long id ,String name, String currency){
        super(id, name, currency);
    }

    public static Moldova getInstance(){
        if (INSTANCE == null) INSTANCE = new Moldova(1L, "Moldova", "MDL");

        return INSTANCE;
    }

}
