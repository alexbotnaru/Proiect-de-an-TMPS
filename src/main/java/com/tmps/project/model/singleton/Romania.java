package com.tmps.project.model.singleton;

import com.tmps.project.model.Country;

public class Romania extends Country {
    private static Romania INSTANCE;

    private Romania(Long id, String name, String currency){
        super(id, name, currency);
    }

    public static Romania getInstance(){
        if (INSTANCE == null) INSTANCE = new Romania(2L, "Romania", "RON");

        return INSTANCE;
    }

}
