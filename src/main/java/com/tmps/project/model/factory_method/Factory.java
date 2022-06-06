package com.tmps.project.model.factory_method;

import com.tmps.project.model.Country;

public interface Factory {
    Country getCountry(String name);
}
