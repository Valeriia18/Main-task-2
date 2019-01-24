package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongBodyTypeException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongCostException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongNameException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongYearException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import java.util.Arrays;

/**
 *
 * Finder class needs to find cars from station using specific parameters
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class Finder {

    public static Car[] findCarByName(TaxiStation taxi, String name)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (name == "" || name == null) {
            throw new WrongNameException();
        }

        Car[] result = null;
        Car[] cars = taxi.getCars();
        name = name.toUpperCase();
        for (Car car : cars) {
            if ((car.getName().toUpperCase()).equals(name)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[cars.length - 1] = car;
            }
        }
        return result;
    }

    public static Car[] findCarByYear(TaxiStation taxi, int year)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (year < 0) {
            throw new WrongYearException();
        }

        Car[] result = null;
        Car[] cars = taxi.getCars();
        for (Car car : cars) {
            if (car.getYear() == year) {
                result = Arrays.copyOf(result, result.length + 1);
                result[cars.length - 1] = car;
            }
        }
        return result;
    }

    public static Car[] findCarByCost(TaxiStation taxi, int cost) 
            throws LogicException{
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (cost < 0) {
            throw new WrongCostException();
        }
        
        Car[] result = null;
        Car[] cars = taxi.getCars();
        for (Car car : cars) {
            if (car.getCost() == cost) {
                result = Arrays.copyOf(result, result.length + 1);
                result[cars.length - 1] = car;
            }
        }
        return result;
    }

    public static Car[] findCarByBody(TaxiStation taxi, String body)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        try {
            BodyType.valueOf(body);
        } catch(IllegalArgumentException e) {
            throw new WrongBodyTypeException();
        }
        
        Car[] result = null;
        Car[] cars = taxi.getCars();
        body = body.toUpperCase();
        for (Car car : cars) {
            if ((car.getBody()).equals(body)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[cars.length - 1] = car;
            }
        }
        return result;
    }
}
