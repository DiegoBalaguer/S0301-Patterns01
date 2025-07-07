package level03.exercise01.application;

import level03.exercise01.Command;
import level03.exercise01.model.Vehicle;

import java.util.*;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class ApplicationController {

    private static ApplicationController appController = new ApplicationController();
    private List<Vehicle> vehiclesList = new ArrayList<>();
    private List<Command> commandsParking = new ArrayList<>();
    ApplicationWorkers workers = ApplicationWorkers.getWorkers(vehiclesList, commandsParking);

    private ApplicationController() {}

    public static ApplicationController getAppController() {
        return appController;
    }

    public void run() {
        workers.addVehicles();
        workers.addTasksParking();
        workers.getTasksParking();


    }

}
