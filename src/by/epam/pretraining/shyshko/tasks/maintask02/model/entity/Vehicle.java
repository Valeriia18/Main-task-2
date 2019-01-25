package by.epam.pretraining.shyshko.tasks.maintask02.model.entity;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongConsumptionException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongCostException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.WrongYearException;
import java.util.Objects;

/**
 *
 * Base class of vehicle
 *
 * version 1.0
 *
 * @author Paul Shyshko 21.01.2019
 */
public class Vehicle {

    private String brand;
    private int year;
    private int cost;
    private FuelType fuelType;
    private double fuelConsumption;

    protected Vehicle() {

    }

    protected Vehicle(String brand, int year, int cost, FuelType fuelType,
            double fuelConsumption) throws LogicException {
        this.brand = brand;
        if (year > 0) {
            this.year = year;
        }
        if (cost > 0) {
            this.cost = cost;
        }
        this.fuelType = fuelType;
        if (fuelConsumption > 0) {
            this.fuelConsumption = fuelConsumption;
        }
    }

    protected Vehicle(Vehicle other) {
        this.brand = new String(other.brand);
        this.year = other.year;
        this.cost = other.cost;
        this.fuelType = other.fuelType;
        this.fuelConsumption = other.fuelConsumption;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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
        hash = PRIME * hash + Objects.hashCode(this.brand);
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
        if ((this.fuelType).equals(other.fuelType)) {
            return false;
        }
        if (this.fuelConsumption != other.fuelConsumption) {
            return false;
        }
        return Objects.equals(this.brand, other.brand);
    }

    @Override
    public String toString() {
        return brand + ", " + year + ", " + fuelType + ", consumption: "
                + fuelConsumption + ", costs: " + cost;
    }
}
