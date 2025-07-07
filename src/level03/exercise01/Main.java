package level03.exercise01;

import level03.exercise01.application.ApplicationController;

/**
 * PROGRAM: Main
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class Main {

    public static void main(String[] args) {

        ApplicationController appController = ApplicationController.getAppController();

        appController.run();

        System.out.println("PROCESS FINISHED...");
    }
}