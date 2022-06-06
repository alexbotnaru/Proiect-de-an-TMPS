package com.tmps.project.model.factory_method;

import com.tmps.project.model.Country;

public class CountryFactory implements Factory {
    public Country getCountry(String name) {
        if (name == null) return null;
        else if (name.equalsIgnoreCase("Moldova"))
            return new Moldova();
        else if (name.equalsIgnoreCase("Romania"))
            return new Romania();
        else if (name.equalsIgnoreCase("Bulgaria"))
            return new Bulgaria();
        else return null;
    }
}
