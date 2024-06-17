package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Метод показывает все полёты, где общее время, проведённое на земле, превышает два часа
 */
public class TimeSpentOnEarthExceedsTwoHours implements Filter {
    @Override
    public List<Flight> check(List<Flight> flightSheet) {
        System.out.println("Полёты, где общее время, проведённое на земле, превышает два часа: ");
        List<Flight> list = new ArrayList<>();
        flightSheet.forEach(flight -> {
                    int size = flight.getSegments().size();
                    if (size > 1) {
                        int countHours = 0;
                        for (int i = 1; i < size; i++) {
                            countHours += transferTime(flight.getSegments()
                                    .get(i - 1).getArrivalDate(), flight
                                    .getSegments().get(i).getDepartureDate());
                        }
                        if (countHours <= 2) {
                            list.add(flight);
                        }
                    } else {
                        list.add(flight);
                    }
                }
        );
        return list;
    }

    public int transferTime(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
