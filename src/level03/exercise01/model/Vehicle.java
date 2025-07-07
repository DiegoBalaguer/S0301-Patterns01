package level03.exercise01.model;

/**
 * PROGRAM: Vehicle
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class Vehicle {
    private final String TYPE_VEHICLE;
    private String name;

    public Vehicle(String typeVehicle, String name) {
        TYPE_VEHICLE = typeVehicle;
        this.name = name;
    }

    public String turnOn() {
        return "Vehicle type " + TYPE_VEHICLE + " turns on";
    }

    public String accelerate() {
        return "Vehicle type " + TYPE_VEHICLE + " accelerate";
    }

    public String brake() {
        return "Vehicle type " + TYPE_VEHICLE + " brake";
    }

}
