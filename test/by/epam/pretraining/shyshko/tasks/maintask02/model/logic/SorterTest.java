package by.epam.pretraining.shyshko.tasks.maintask02.model.logic;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SorterTest {

    TaxiStation taxi = new TaxiStation();

    @BeforeClass
    public void init() throws LogicException {
        taxi.addCar(new Car("Audi A3", 2005, 10000, "DIESEL", 5, "HATCHBACK"));
        taxi.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        taxi.addCar(new Car("Volkswagen Sharan", 2009, 13000, "DIESEL", 8, "MINIVAN"));
        taxi.addCar(new Car("Audi A4", 2002, 5500, "DIESEL", 6, "WAGON"));
        taxi.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7.5, "SEDAN"));
    }

    @Test
    public void testSortByYear() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        expecteds.addCar(new Car("Audi A4", 2002, 5500, "DIESEL", 6, "WAGON"));
        expecteds.addCar(new Car("Audi A3", 2005, 10000, "DIESEL", 5, "HATCHBACK"));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, "DIESEL", 8, "MINIVAN"));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7.5, "SEDAN"));

        Sorter.sortByYear(taxi);

        assertEquals(expecteds, taxi);
    }

    @Test
    public void testSortByConsumption() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A3", 2005, 10000, "DIESEL", 5, "HATCHBACK"));
        expecteds.addCar(new Car("Audi A4", 2002, 5500, "DIESEL", 6, "WAGON"));
        expecteds.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7.5, "SEDAN"));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, "DIESEL", 8, "MINIVAN"));

        Sorter.sortByConsumption(taxi);

        assertEquals(expecteds, taxi);
    }

    @Test
    public void testSortByCost() throws LogicException {
        TaxiStation expecteds = new TaxiStation();
        expecteds.addCar(new Car("Audi A4", 2002, 5500, "DIESEL", 6, "WAGON"));
        expecteds.addCar(new Car("Audi A6", 2000, 6000, "DIESEL", 7, "SEDAN"));
        expecteds.addCar(new Car("Audi A3", 2005, 10000, "DIESEL", 5, "HATCHBACK"));
        expecteds.addCar(new Car("Volkswagen Sharan", 2009, 13000, "DIESEL", 8, "MINIVAN"));
        expecteds.addCar(new Car("Audi A6", 2015, 20000, "DIESEL", 7.5, "SEDAN"));

        Sorter.sortByCost(taxi);

        assertEquals(expecteds, taxi);
    }

}
