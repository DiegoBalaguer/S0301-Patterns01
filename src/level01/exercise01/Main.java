package level01.exercise01;

import level01.exercise01.application.AppController;

/**
 * PROGRAM: Main
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class Main {

    public static void main(String[] args) {

        AppController.getInstance().run();

        System.out.println("PROCESS FINISHED...");
    }
}