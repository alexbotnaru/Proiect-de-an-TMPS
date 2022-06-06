package com.tmps.project.iterator;

import com.tmps.project.model.Trip;

import java.util.LinkedList;
import java.util.List;

public class TripIterator implements Iterator<Trip> {

    Trip[] trips;
    int index;

    public TripIterator(Trip[] trips) {
        this.trips = trips;
    }

    @Override
    public boolean hasNext() {
        return index < trips.length;
    }

    @Override
    public Trip next() {
        if (this.hasNext()) return trips[index++];

        return null;
    }
}
