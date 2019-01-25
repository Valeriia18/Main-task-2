package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Vehicle;

/**
 *
 * Sorter needs to sort station cars by their significant features
 * 
 * version 1.1
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
        Vehicle[] vehicles = taxi.getVehicles();
        boolean isSorted;
        for (int i = vehicles.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (vehicles[j].getYear() > vehicles[j + 1].getYear()) {
                    Vehicle tmp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = tmp;
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
        Vehicle[] vehicles = taxi.getVehicles();
        boolean isSorted;
        for (int i = vehicles.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (vehicles[j].getFuelConsumption()> vehicles[j + 1].getFuelConsumption()) {
                    Vehicle tmp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = tmp;
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
        Vehicle[] vehicles = taxi.getVehicles();
        boolean isSorted;
        for (int i = vehicles.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (vehicles[j].getCost()> vehicles[j + 1].getCost()) {
                    Vehicle tmp = vehicles[j];
                    vehicles[j] = vehicles[j + 1];
                    vehicles[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted == true) {
                break;
            }
        }
    }  
}