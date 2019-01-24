package by.epam.pretraining.shyshko.tasks.maintask02.controller;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.logic.Logic;
import by.epam.pretraining.shyshko.tasks.maintask02.utils.TaxiStationCreator;
import java.io.FileNotFoundException;
import org.apache.log4j.Logger;

/**
 *
 * Controller main class
 * 
 * The application illustrates a taxi station of passenger cars
 * 
 * version 1.0
 * 
 * @author Paul Shyshko
 * 21.01.2019
 * 
 * P.S. I don't know how to write correct developer comments
 * that's the first time I do this
 */

public class Controller {

    private static final Logger LOG = Logger.getRootLogger();

    public static void main(String[] args) {
        TaxiStation taxi = new TaxiStation();
        try {
            taxi = TaxiStationCreator.initStation();
        } catch (FileNotFoundException e) {
            LOG.fatal(e);
        } catch (LogicException e) {
            LOG.warn(e);
        }

        LOG.info(taxi);
        try {
            LOG.info("Tottal cost of station: " + Logic.findTotalCost(taxi));
            LOG.info("The cheapest car: " + Logic.findCheapestCar(taxi));
            LOG.info("The most expensive car: " + Logic.findTheMostExpenisveCar(taxi));
            LOG.info("The newest car: " + Logic.findNewestCar(taxi));
        } catch (NotInitializedStationException e) {
            LOG.fatal(e);
        }
    }
}
