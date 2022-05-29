package com.tmps.project.model.singleton;

import com.tmps.project.model.Country;

public class Romania extends Country {
    private static Romania INSTANCE;

    private Romania(String name, String currency){
        super(name, currency);
    }

    public static Romania getInstance(){
        if (INSTANCE == null) INSTANCE = new Romania("Romania", "RON");

        return INSTANCE;
    }

}
