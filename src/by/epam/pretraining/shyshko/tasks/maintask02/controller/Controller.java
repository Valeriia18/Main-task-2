package by.epam.pretraining.shyshko.tasks.maintask02.controller;

import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.LogicException;
import by.epam.pretraining.shyshko.tasks.maintask02.exceptions.NotInitializedStationException;
import by.epam.pretraining.shyshko.tasks.maintask02.model.entity.TaxiStation;
import by.epam.pretraining.shyshko.tasks.maintask02.model.logic.TaxiStationManager;
import by.epam.pretraining.shyshko.tasks.maintask02.utils.TaxiStationCreator;
import org.apache.log4j.Logger;

/**
 *
 * Controller main class
 * 
 * The application illustrates a taxi station of passenger cars
 * 
 * version 1.1
 * 
 * @author Paul Shyshko
 * 21.01.2019
 */

public class Controller {

    private static final Logger LOG = Logger.getRootLogger();

    public static void main(String[] args) {
        TaxiStation taxi = new TaxiStation();
        try {
            taxi = TaxiStationCreator.initStation();
        } catch (LogicException e) {
            LOG.warn(e);
        } catch (Exception e) {
            LOG.fatal(e);
        } 

        LOG.info(taxi);
        try {
            LOG.info("Tottal cost of station: " + TaxiStationManager.calculateTotalCost(taxi));
            LOG.info("The cheapest vehicle: " + TaxiStationManager.findCheapestVehicle(taxi));
            LOG.info("The most expensive vehicle: " + TaxiStationManager.findTheMostExpenisveVehicle(taxi));
            LOG.info("The newest vehicle: " + TaxiStationManager.findNewestVehicle(taxi));
        } catch (NotInitializedStationException e) {
            LOG.fatal(e);
        }
    }
}
