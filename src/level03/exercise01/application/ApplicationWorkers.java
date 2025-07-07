package level03.exercise01.application;

import level03.exercise01.Command;
import level03.exercise01.actions.AccelerateVehicle;
import level03.exercise01.actions.BrakeVehicle;
import level03.exercise01.actions.TurnOnVehicle;
import level03.exercise01.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAM: ApplicationWorkers
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class ApplicationWorkers {
    private static ApplicationWorkers workers = new ApplicationWorkers();
    private static List<Vehicle> vehiclesList = new ArrayList<>();
    private static List<Command> commandsParking = new ArrayList<Command>();

    private ApplicationWorkers() {
    }

    public static ApplicationWorkers getWorkers(List<Vehicle> vehiclesInput, List<Command> commandsInput) {
        vehiclesList = vehiclesInput;
        commandsParking = commandsInput;
        return workers;
    }

    public void addVehicles() {
        vehiclesList.add(new Vehicle("CAR", "Seat"));
        vehiclesList.add(new Vehicle("BIKE", "Cannondale"));
        vehiclesList.add(new Vehicle("PLANE", "Concorde"));
        vehiclesList.add(new Vehicle("BOAT", "Star Line"));
    }

    public void addTasksParking() {
        for (Vehicle vehicle : vehiclesList) {
            commandsParking.add(new TurnOnVehicle(vehicle));
            commandsParking.add(new AccelerateVehicle(vehicle));
            commandsParking.add(new BrakeVehicle(vehicle));
        }
    }

    public void getTasksParking() {
        for (Command task : commandsParking) {
            System.out.println(task.execute());
        }
    }
}
