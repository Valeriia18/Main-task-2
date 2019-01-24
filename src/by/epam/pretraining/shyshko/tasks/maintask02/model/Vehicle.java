package by.epam.pretraining.shyshko.tasks.maintask02.model;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongConsumptionException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongCostException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongFuelTypeException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongYearException;
import java.util.Objects;

/**
 *
 * Base class of vehicle
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class Vehicle {

    private String name;
    private int year;
    private int cost;
    private FuelType fuelType;
    private double fuelConsumption;

    protected Vehicle() {

    }

    protected Vehicle(String name, int year, int cost, String fuelType,
            double fuelConsumption) throws LogicException {
        this.name = name;
        if (year > 0) {
            this.year = year;
        } else {
            throw new WrongYearException();
        }
        if (cost > 0) {
            this.cost = cost;
        } else {
            throw new WrongCostException();
        }
        try {
            this.fuelType = FuelType.valueOf(fuelType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new WrongFuelTypeException();
        }
        if (fuelConsumption > 0) {
            this.fuelConsumption = fuelConsumption;
        } else {
            throw new WrongConsumptionException();
        }
    }

    protected Vehicle(Vehicle other) {
        this.name = new String(other.name);
        this.year = other.year;
        this.cost = other.cost;
        this.fuelType = other.fuelType;
        this.fuelConsumption = other.fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws WrongYearException {
        if (year > 0) {
            this.year = year;
        } else {
            throw new WrongYearException();
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) throws WrongCostException {
        if (cost > 0) {
            this.cost = cost;
        } else {
            throw new WrongCostException();
        }
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) throws WrongFuelTypeException {
        try {
            this.fuelType = FuelType.valueOf(fuelType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new WrongFuelTypeException();
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption)
            throws WrongConsumptionException {
        if (fuelConsumption > 0) {
            this.fuelConsumption = fuelConsumption;
        } else {
            throw new WrongConsumptionException();
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 47;
        int hash = 7;
        hash = PRIME * hash + Objects.hashCode(this.name);
        hash = PRIME * hash + this.year;
        hash = PRIME * hash + this.cost;
        hash = PRIME * hash + Objects.hashCode(this.fuelType);
        hash = PRIME * hash + (int) fuelConsumption;
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
        final Vehicle other = (Vehicle) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        if ((this.fuelType.name()).equals(other.fuelType.name())) {
            return false;
        }
        if (this.fuelConsumption != other.fuelConsumption) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}
