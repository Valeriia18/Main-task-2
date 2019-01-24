package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogicTest {

    TaxiStation taxi = new TaxiStation();

    @BeforeClass
    public void init() throws LogicException {
        taxi.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Audi A6", 2002, 6500, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Audi A6", 2005, 10000, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Audi A6", 2009, 13000, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7, "SEDAN"));
    }

    @Test
    public void testFindTotalCost() throws NotInitializedStationException {
        assertEquals(55000, Logic.findTotalCost(taxi));
    }
    @Test
    public void testFindCheapestCar() throws NotInitializedStationException {
        assertEquals(taxi.getCarByID(0), Logic.findCheapestCar(taxi));
    }
    @Test
    public void testFindTheMostExpensiveCar() throws NotInitializedStationException {
        assertEquals(taxi.getCarByID(4), Logic.findTheMostExpenisveCar(taxi));
    }
    @Test
    public void testFindNewestCar() throws NotInitializedStationException {
        assertEquals(taxi.getCarByID(4), Logic.findNewestCar(taxi));
    }
}
