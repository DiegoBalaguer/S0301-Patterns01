package level03.exercise01.application;

import level03.exercise01.Command;
import level03.exercise01.model.Vehicle;

import java.util.*;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class AppController {

    private static AppController appController = new AppController();
    private List<Vehicle> vehiclesList = new ArrayList<>();
    private List<Command> commandsParking = new ArrayList<>();
    AppWorkers workers = AppWorkers.getWorkers(vehiclesList, commandsParking);

    private AppController() {}

    public static AppController getAppController() {
        return appController;
    }

    public void run() {
        workers.addVehicles();
        workers.addTasksParking();
        workers.getTasksParking();


    }

}
