package com.gridnine.testing;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightCheck flightCheck = new FlightCheck();
        flightCheck.setFlights(flights);

        flightCheck.setFilter(new BeforeDepartureDate());
        printFlightList(flightCheck.executeFilter());

        flightCheck.setFilter(new CurrentDepartureTime());
        printFlightList(flightCheck.executeFilter());

        flightCheck.setFilter(new TimeSpentOnEarthExceedsTwoHours());
        printFlightList(flightCheck.executeFilter());
    }

    public static void printFlightList(List<Flight> flightSheet) {
        flightSheet.forEach(System.out::println);
        System.out.println("=================================");
    }
}
