package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.FuelType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaxiStationManagerTest {

    TaxiStation taxi = new TaxiStation();

    @BeforeClass
    public void init() throws LogicException {
        taxi.addCar(new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN));
        taxi.addCar(new Car("Audi A6", 2002, 6500, FuelType.DIESEL, 7, BodyType.SEDAN));
        taxi.addCar(new Car("Audi A6", 2005, 10000, FuelType.DIESEL, 7, BodyType.SEDAN));
        taxi.addCar(new Car("Audi A6", 2009, 13000, FuelType.DIESEL, 7, BodyType.SEDAN));
        taxi.addCar(new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN));
    }

    @Test
    public void testFindTotalCost() throws NotInitializedStationException {
        assertEquals(55500, TaxiStationManager.calculateTotalCost(taxi));
    }
    @Test
    public void testFindCheapestCar() throws NotInitializedStationException {
        assertEquals(taxi.getVehicleByIndex(0), TaxiStationManager.findCheapestVehicle(taxi));
    }
    @Test
    public void testFindTheMostExpensiveCar() throws NotInitializedStationException {
        assertEquals(taxi.getVehicleByIndex(4), TaxiStationManager.findTheMostExpenisveVehicle(taxi));
    }
    @Test
    public void testFindNewestCar() throws NotInitializedStationException {
        assertEquals(taxi.getVehicleByIndex(4), TaxiStationManager.findNewestVehicle(taxi));
    }
}
