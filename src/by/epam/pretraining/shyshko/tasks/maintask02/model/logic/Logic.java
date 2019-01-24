package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;

/**
 *
 * Logic class needs to do some logic as calculating total cost of all cars of 
 * the taxi station
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class Logic {

    public static int findTotalCost(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        int sum = 0;
        Car[] cars = taxi.getCars();
        if (taxi.getCars() != null) {
            for (Car car : cars) {
                sum += car.getCost();
            }
        }
        return sum;
    }
    
    public static Car findCheapestCar(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        int index = 0;
        int minCost = Integer.MAX_VALUE;
        Car[] cars = taxi.getCars();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCost() < minCost) {
                index = i;
                minCost = cars[i].getCost();
            }
        }
        return cars[index];
    }
    
    public static Car findTheMostExpenisveCar(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        int index = 0;
        int maxCost = 0;
        Car[] cars = taxi.getCars();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCost() > maxCost) {
                index = i;
                maxCost = cars[i].getCost();
            }
        }
        return cars[index];
    }

    public static Car findNewestCar(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        
        int index = 0;
        int maxYear = 0;
        Car[] cars = taxi.getCars();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getYear() > maxYear) {
                index = i;
                maxYear = cars[i].getYear();
            }
        }
        return cars[index];
    }
}