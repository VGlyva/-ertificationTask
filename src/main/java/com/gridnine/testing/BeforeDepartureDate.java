package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Метод показывает все сегменты с датой прилёта раньше даты вылета
 */
public class BeforeDepartureDate implements Filter {
    @Override
    public List<Flight> check(List<Flight> flightSheet) {
        System.out.println("Сегменты с датой прилёта раньше даты вылета: ");
        List<Flight> list = new ArrayList<>();
        flightSheet.forEach(flight -> flight.getSegments()
                .stream()
                .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()))
                .limit(1)
                .forEach(segment -> list.add(flight)));
        return list;
    }
}
