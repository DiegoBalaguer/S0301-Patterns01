package level02.exercise01;

import level02.exercise01.application.AppController;

/**
 * PROGRAM: Main
 * AUTHOR: Diego Balaguer
 * DATE: 01/06/2025
 */

public class Main {

    public static void main(String[] args) {

        AppController.getInstance().run();

        System.out.println("PROCESS FINISHED...");
    }
}