package by.epam.pretraining.shyshko.tasks.maintask02.utils;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.Car;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TaxiStationCreator {

    public static TaxiStation initStation() throws LogicException, 
            FileNotFoundException {
        File file = new File("D:\\file.txt");

        Scanner sc;
        sc = new Scanner(file);
        
        TaxiStation result = new TaxiStation();

        while (sc.hasNextLine()) {
            Car car = new Car();
            String data = sc.nextLine();
            StringTokenizer token = new StringTokenizer(data, ",");
            while (token.hasMoreTokens()) {
                car.setName(token.nextToken());
                car.setYear(Integer.parseInt(token.nextToken()));
                car.setCost(Integer.parseInt(token.nextToken()));
                car.setFuelType(token.nextToken());
                car.setFuelConsumption(Double.parseDouble(token.nextToken()));
                car.setBody(token.nextToken());
            }
            result.addCar(car);
        }
        return result;
    }
}
