package level03.exercise01.actions;

import level03.exercise01.Command;
import level03.exercise01.model.Vehicle;

/**
 * PROGRAM: BrakeVehicle
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class BrakeVehicle implements Command {
    private Vehicle vehicle;

    public BrakeVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        return vehicle.brake();
    }
}