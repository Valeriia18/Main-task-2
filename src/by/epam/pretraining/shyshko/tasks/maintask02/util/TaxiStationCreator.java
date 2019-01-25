package by.epam.pretraining.shyshko.tasks.maintask02.utils;

import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.BodyType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.FuelType;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TaxiStationCreator {

    public static TaxiStation initStation() throws Exception {

        FileInputStream fis = new FileInputStream("src/config.properties");
        Properties property = new Properties();

        property.load(fis);

        File inputFile = new File(property.getProperty("inputfile"));

        Scanner sc;
        sc = new Scanner(inputFile);

        TaxiStation result = new TaxiStation();

        while (sc.hasNextLine()) {
            Car car = new Car();
            String data = sc.nextLine();
            StringTokenizer token = new StringTokenizer(data, ",");
            while (token.hasMoreTokens()) {
                car.setBrand(token.nextToken());
                car.setYear(Integer.parseInt(token.nextToken()));
                car.setCost(Integer.parseInt(token.nextToken()));
                car.setFuelType(FuelType.valueOf(token.nextToken()));
                car.setFuelConsumption(Double.parseDouble(token.nextToken()));
                car.setBody(BodyType.valueOf(token.nextToken()));
            }
            result.addCar(car);
        }
        return result;
    }
}
