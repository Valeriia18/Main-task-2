package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Vehicle;

/**
 *
 * Logic class does some logic as calculating total cost of all cars of 
 * the taxi station
 * 
 * version 1.1
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class TaxiStationManager {

    public static int calculateTotalCost(TaxiStation taxi) {
        if (taxi == null) {
            return 0;
        }
        int sum = 0;
        Vehicle[] vehicles = taxi.getVehicles();
        if (taxi.getVehicles()!= null) {
            for (Vehicle vehicle : vehicles) {
                sum += vehicle.getCost();
            }
        }
        return sum;
    }
    
    public static Vehicle findCheapestVehicle(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        int index = 0;
        int minCost = Integer.MAX_VALUE;
        Vehicle[] vehicles = taxi.getVehicles();
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getCost() < minCost) {
                index = i;
                minCost = vehicles[i].getCost();
            }
        }
        return vehicles[index];
    }
    
    public static Vehicle findTheMostExpenisveVehicle(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        int index = 0;
        int maxCost = 0;
        Vehicle[] vehicles = taxi.getVehicles();
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getCost() > maxCost) {
                index = i;
                maxCost = vehicles[i].getCost();
            }
        }
        return vehicles[index];
    }

    public static Vehicle findNewestVehicle(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        
        int index = 0;
        int maxYear = 0;
        Vehicle[] vehicles = taxi.getVehicles();
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getYear() > maxYear) {
                index = i;
                maxYear = vehicles[i].getYear();
            }
        }
        return vehicles[index];
    }
}