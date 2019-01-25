package by.epam.pretraining.shyshko.tasks.maintask02.model.entity;

import java.util.Arrays;

/**
 *
 * This class illustrates taxi station with cars composition has usual container
 * class methods
 *
 * version 1.0
 *
 * @author Paul Shyshko 21.01.2019
 */
public class TaxiStation {

    private Vehicle[] vehicles;

    public TaxiStation() {
        vehicles = new Car[0];
    }

    public TaxiStation(Car[] carArray) {
        vehicles = Arrays.copyOf(carArray, carArray.length);
    }

    public TaxiStation(TaxiStation taxi) {
        Vehicle[] carArray = taxi.getVehicles();
        vehicles = Arrays.copyOf(carArray, carArray.length);
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    public int getNumberOfVehicles() {
        return vehicles.length;
    }

    public boolean isEmpty() {
        return vehicles.length == 0;
    }

    public Vehicle getVehicleByIndex(int index) {
        if (index < vehicles.length) {
            return vehicles[index];
        }
        return null;
    }

    public void deleteAllVehicles() {
        vehicles = Arrays.copyOf(vehicles, 0);
    }

    public void deleteVehicle(int id) {
        for (int i = 0; i < vehicles.length; i++) {
            if (i == id) {
                for (int j = i; j < vehicles.length - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles = Arrays.copyOf(vehicles, vehicles.length - 1);
                break;
            }
        }
    }

    public void addCar(Car car) {
        vehicles = Arrays.copyOf(vehicles, vehicles.length + 1);
        vehicles[vehicles.length - 1] = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Vehicle car : vehicles) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Arrays.deepHashCode(this.vehicles);
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
        return Arrays.deepEquals(this.vehicles, other.vehicles);
    }
}
