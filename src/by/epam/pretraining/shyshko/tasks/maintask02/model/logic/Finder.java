package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongBodyTypeException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongCostException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongNameException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongYearException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Vehicle;
import java.util.Arrays;

/**
 *
 * Finder class needs to find vehicles from station using specific parameters
 *
 * version 1.1
 *
 * @author Paul Shyshko 21.01.2019
 */
public class Finder {

    public static Vehicle[] findVehicleByBrand(TaxiStation taxi, String brand)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (brand.equals("") || brand == null) {
            throw new WrongNameException();
        }

        Vehicle[] result = new Vehicle[0];
        Vehicle[] vehicles = taxi.getVehicles();
        brand = brand.toUpperCase();
        for (Vehicle veh : vehicles) {
            if ((veh.getBrand().toUpperCase()).equals(brand)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = veh;
            }
        }
        return result;
    }

    public static Vehicle[] findVehicleByYear(TaxiStation taxi, int year)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (year < 0) {
            throw new WrongYearException();
        }

        Vehicle[] result = new Vehicle[0];
        Vehicle[] vehicles = taxi.getVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() == year) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = vehicle;
            }
        }
        return result;
    }

    public static Vehicle[] findVehicleByCost(TaxiStation taxi, int cost)
            throws LogicException {
        if (taxi == null) {
            throw new NotInitializedStationException();
        }
        if (cost < 0) {
            throw new WrongCostException();
        }

        Vehicle[] result = new Vehicle[0];
        Vehicle[] vehicles = taxi.getVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCost() == cost) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = vehicle;
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
        } catch (IllegalArgumentException e) {
            throw new WrongBodyTypeException();
        }

        Car[] result = new Car[0];
        Vehicle[] vehicles = taxi.getVehicles();
        body = body.toUpperCase();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass() == Car.class) {
                if ((((Car)vehicle).getBody()).equals(body)) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = (Car)vehicle;
                }
            }
        }
        return result;
    }
}
