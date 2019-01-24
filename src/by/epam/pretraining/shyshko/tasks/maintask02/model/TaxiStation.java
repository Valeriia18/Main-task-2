package by.epam.pretraining.shyshko.tasks.maintask02.model;

import java.util.Arrays;

/**
 *
 * This class illustrates taxi station with cars composition
 * has usual container class methods
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class TaxiStation {

    private Car[] cars;
    
    public TaxiStation() {
        
    }
    
    public TaxiStation(Car[] carArray) {
        cars = Arrays.copyOf(carArray, carArray.length);
    }
    
    public TaxiStation(TaxiStation taxi) {
        Car[] carArray = taxi.getCars();
        cars = Arrays.copyOf(carArray, carArray.length);
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return cars.length;
    }

    public boolean isEmpty() {
        return cars.length == 0;
    }

    public Car getCarByID(int id) {
        for (int i = 0; i < cars.length; i++) {
            if (i == id) {
                return cars[i];
            }
        }
        return null;
    }

    public void clearTaxi() {
        cars = Arrays.copyOf(cars, 0);
    }

    public void deleteCar(int id) {
        for (int i = 0; i < cars.length; i++) {
            if (i == id) {
                for (int j = i; j < cars.length - 1; j++) {
                    cars[j] = cars[j + 1];
                }
                cars = Arrays.copyOf(cars, cars.length - 1);
                break;
            }
        }
    }

    public void addCar(Car car) {
        if (cars != null) {
            cars = Arrays.copyOf(cars, cars.length + 1);
            cars[cars.length - 1] = car;
        } else {
            cars = new Car[1];
            cars[0] = car;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Arrays.deepHashCode(this.cars);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxiStation other = (TaxiStation) obj;
        return Arrays.deepEquals(this.cars, other.cars);
    }
}