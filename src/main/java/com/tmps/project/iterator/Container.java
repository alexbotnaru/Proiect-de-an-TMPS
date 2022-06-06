package com.tmps.project.iterator;

import com.tmps.project.model.Trip;

public interface Container {
    Iterator getIterator(Trip[] trips);
}
