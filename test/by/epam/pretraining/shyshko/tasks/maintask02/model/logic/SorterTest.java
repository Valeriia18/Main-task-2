package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.FuelType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SorterTest {

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
    public void testSortByYear() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN));
        expecteds.addCar(new Car("Audi A4", 2002, 5500, FuelType.DIESEL, 7, BodyType.WAGON));
        expecteds.addCar(new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, FuelType.DIESEL, 7, BodyType.MINIVAN));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN));

        Sorter.sortByYear(taxi);

        assertEquals(expecteds, taxi);
    }

    @Test
    public void testSortByConsumption() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK));
        expecteds.addCar(new Car("Audi A4", 2002, 5500, FuelType.DIESEL, 7, BodyType.WAGON));
        expecteds.addCar(new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, FuelType.DIESEL, 7, BodyType.MINIVAN));

        Sorter.sortByConsumption(taxi);

        assertEquals(expecteds, taxi);
    }

    @Test
    public void testSortByCost() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A4", 2002, 5500, FuelType.DIESEL, 7, BodyType.WAGON));
        expecteds.addCar(new Car("Audi A6", 2000, 6000, FuelType.DIESEL, 7, BodyType.SEDAN));
        expecteds.addCar(new Car("Audi A3", 2005, 10000, FuelType.DIESEL, 7, BodyType.HATCHBACK));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, FuelType.DIESEL, 7, BodyType.MINIVAN));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, FuelType.DIESEL, 7, BodyType.SEDAN));

        Sorter.sortByCost(taxi);

        assertEquals(expecteds, taxi);
    }

}
