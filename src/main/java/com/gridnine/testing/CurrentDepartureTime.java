package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Метод показывает все полёты до текущего момента времени
 */
public class CurrentDepartureTime implements Filter {
    @Override
    public List<Flight> check(List<Flight> flightSheet) {
        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println("Полёты, где вылет до текущего момента времени: ");
        List<Flight> list = new ArrayList<>();
        for (Flight flight : flightSheet) {
            for (Segment segment : flight.getSegments()) {
                if (timeNow.isBefore(segment.getDepartureDate())) {
                    list.add(flight);
                    break;
                }
            }
        }
        return list;
    }
}
