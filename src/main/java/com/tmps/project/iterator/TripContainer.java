package com.tmps.project.iterator;

import com.tmps.project.model.Trip;

public class TripContainer implements Container{
    @Override
    public Iterator<Trip> getIterator(Trip[] trips) {
        return new TripIterator(trips);
    }
}
