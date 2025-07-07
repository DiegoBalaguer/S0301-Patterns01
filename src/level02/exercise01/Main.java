package level02.exercise01;

import level02.exercise01.application.ApplicationController;

/**
 * PROGRAM: Main
 * AUTHOR: Diego Balaguer
 * DATE: 01/06/2025
 */

public class Main {

    public static void main(String[] args) {

        ApplicationController applicationController = new ApplicationController();

        applicationController.run();

        System.out.println("PROCESS FINISHED...");
    }
}