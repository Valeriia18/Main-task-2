package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinderTest {
    TaxiStation taxi = new TaxiStation();

    @BeforeClass
    public void init() throws LogicException {
        taxi.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Audi A4", 2002, 5500, "DIESEL", 7, "WAGON"));
        taxi.addCar(new Car("Audi A3", 2005, 10000, "DIESEL", 7, "HATCHBACK"));
        taxi.addCar(new Car("Volkswagen Sharan", 2009, 13000, "DIESEL", 7, "MINIVAN"));
        taxi.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7, "SEDAN"));
    }
    
    @Test
    public void testFindCarByName() throws LogicException {
        Car[] expecteds = new Car[2];
        expecteds[1] = new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN");
        expecteds[2] = new Car("Audi A6", 2015, 20000, "DIESEL", 7, "SEDAN");
        assertEquals(expecteds, Finder.findCarByName(taxi, "Audi A6"));
    }
    
    @Test
    public void testFindCarByYear() throws LogicException {
        Car[] expecteds = new Car[1];
        expecteds[0] = new Car("Audi A3", 2005, 10000, "DIESEL", 7, "HATCHBACK");
        assertEquals(expecteds, Finder.findCarByYear(taxi, 2005));
    }
    
    @Test
    public void testFindCarByCost() throws LogicException {
        Car[] expecteds = new Car[1];
        expecteds[0] = new Car("Audi A3", 2005, 10000, "DIESEL", 7, "HATCHBACK");
        assertEquals(expecteds, Finder.findCarByCost(taxi, 10000));
    }
    
    @Test
    public void testFindCarByBody() throws LogicException {
        Car[] expecteds = new Car[2];
        expecteds[1] = new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN");
        expecteds[2] = new Car("Audi A6", 2015, 20000, "DIESEL", 7, "SEDAN");
        assertEquals(expecteds, Finder.findCarByBody(taxi, "SEDAN"));
    }
}
