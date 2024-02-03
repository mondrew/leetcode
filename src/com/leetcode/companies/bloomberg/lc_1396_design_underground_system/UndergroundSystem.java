package com.leetcode.companies.bloomberg.lc_1396_design_underground_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    static class Passenger {
        public int id;
        public String startStation;
        public String endStation;
        public int startTime;
        public int endTime;

        public Passenger(int id, String startStation, int startTime) {
            this.id = id;
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }

    static class Trip {
        public String id;
        public String startStation;
        public String endStation;
        public long time;

        public Trip(Passenger passenger) {
            this.id = passenger.startStation + "#" + passenger.endStation;
            this.startStation = passenger.startStation;
            this.endStation = passenger.endStation;
            this.time = passenger.endTime - passenger.startTime;
        }
    }

    private Map<Integer, Passenger> passengers = new HashMap<>();
    private Map<String, List<Trip>> tripMap = new HashMap<>();
    private Map<String, Long> totalTimeMap = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Passenger passenger = new Passenger(id, stationName, t);
        passengers.put(id, passenger);
    }

    public void checkOut(int id, String stationName, int t) {
        Passenger passenger = passengers.get(id);
        passenger.endStation = stationName;
        passenger.endTime = t;
        Trip trip = new Trip(passenger);
        List<Trip> route = null;
        if (tripMap.containsKey(trip.id)) {
            route = tripMap.get(trip.id);
        } else {
            route = new ArrayList<>();
            tripMap.put(trip.id, route);
        }
        route.add(trip);
        // Update totalTime map
        Long totalTime;
        totalTime = totalTimeMap.getOrDefault(trip.id, 0L);
        totalTime += trip.time;
        totalTimeMap.put(trip.id, totalTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        Long totalTime = totalTimeMap.get(startStation + "#" + endStation);
        List<Trip> trips = tripMap.get(startStation + "#" + endStation);
        return (double) totalTime / trips.size();
    }
}