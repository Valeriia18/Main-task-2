package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;

/**
 *
 * Sorter needs to sort station cars by significant features of them
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class Sorter {

    public static void sortByYear(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        Car[] cars = taxi.getCars();
        boolean isSorted;
        for (int i = cars.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (cars[j].getYear() > cars[j + 1].getYear()) {
                    Car tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted == true) {
                break;
            }
        }
    }
    
    public static void sortByConsumption(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        Car[] cars = taxi.getCars();
        boolean isSorted;
        for (int i = cars.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (cars[j].getFuelConsumption()> cars[j + 1].getFuelConsumption()) {
                    Car tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted == true) {
                break;
            }
        }
    }
    
    public static void sortByCost(TaxiStation taxi) 
            throws NotInitializedStationException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        Car[] cars = taxi.getCars();
        boolean isSorted;
        for (int i = cars.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (cars[j].getCost()> cars[j + 1].getCost()) {
                    Car tmp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted == true) {
                break;
            }
        }
    }  
}