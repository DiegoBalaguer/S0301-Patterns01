package level03.exercise01;

import level03.exercise01.application.AppController;

/**
 * PROGRAM: Main
 * AUTHOR: Diego Balaguer
 * DATE: 03/06/2025
 */

public class Main {

    public static void main(String[] args) {

        AppController.getAppController().run();

        System.out.println("PROCESS FINISHED...");
    }
}