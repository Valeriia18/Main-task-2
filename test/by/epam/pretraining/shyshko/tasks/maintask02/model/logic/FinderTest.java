package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.FuelType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinderTest {
    TaxiStation taxi = new TaxiStation();

    @BeforeClass
    public void init() throws LogicException {
        taxi.addCar(new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN));
        taxi.addCar(new Car("Audi A4", 2002, 5500, FuelType.DIESEL, 7, BodyType.WAGON));
        taxi.addCar(new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK));
        taxi.addCar(new Car("Volkswagen Sharan", 2009, 13000, FuelType.DIESEL, 7, BodyType.MINIVAN));
        taxi.addCar(new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN));
    }
    
    @Test
    public void testFindVehicleByName() throws LogicException {
        Car[] expecteds = new Car[2];
        expecteds[0] = new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN);
        expecteds[1] = new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN);
        assertEquals(expecteds, Finder.findVehicleByBrand(taxi, "Audi A6"));
    }
    
    @Test
    public void testFindVehicleByYear() throws LogicException {
        Car[] expecteds = new Car[1];
        expecteds[0] = new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK);
        assertEquals(expecteds, Finder.findVehicleByYear(taxi, 2005));
    }
    
    @Test
    public void testFindVehicleByCost() throws LogicException {
        Car[] expecteds = new Car[1];
        expecteds[0] = new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK);
        assertEquals(expecteds, Finder.findVehicleByCost(taxi, 10000));
    }
    
    @Test
    public void testFindCarByBody() throws LogicException {
        Car[] expecteds = new Car[2];
        expecteds[0] = new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN);
        expecteds[1] = new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN);
        assertEquals(expecteds, Finder.findCarByBody(taxi, "SEDAN"));
    }
}
