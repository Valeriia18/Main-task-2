package by.epam.pretraining.shyshko.tasks.maintask02.model.entity;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import java.util.Objects;

/**
 *
 * Entity of car
 *
 * version 1.0
 *
 * @author Paul Shyshko 21.01.2019
 */
public class Car extends Vehicle {

    private BodyType body;

    public Car() {

    }

    public Car(String name, int year, int cost, FuelType fuelType,
            double fuelConsumption, BodyType body) throws LogicException {
        super(name, year, cost, fuelType, fuelConsumption);
        this.body = body;
    }

    public Car(Car other) {
        super(other);
        this.body = other.body;
    }

    public String getBody() {
        return body.name();
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + body.name();
    }

    @Override
    public int hashCode() {
        final int PRIME = 47;
        int hash = 7;
        hash = PRIME * hash + Objects.hashCode(super.getBrand());
        hash = PRIME * hash + super.getYear();
        hash = PRIME * hash + this.getCost();
        hash = PRIME * hash + Objects.hashCode(super.getFuelType().toString());
        hash = PRIME * hash + (int) super.getFuelConsumption();
        hash = PRIME * hash + Objects.hashCode(body.name());
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
        final Car other = (Car) obj;
        if (this.getYear() != other.getYear()) {
            return false;
        }
        if (this.getCost() != other.getCost()) {
            return false;
        }
        if (!(this.getFuelType().name()).equals(other.getFuelType().name())) {
            return false;
        }
        if (this.getFuelConsumption() != other.getFuelConsumption()) {
            return false;
        }
        if (!Objects.equals(this.getBrand(), other.getBrand())) {
            return false;
        }
        return Objects.equals(this.body, other.body);
    }
}
