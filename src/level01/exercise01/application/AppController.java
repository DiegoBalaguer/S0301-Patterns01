package level01.exercise01.application;

import level01.exercise01.model.ConsoleApp;
import utils.ConsoleUtils;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class AppController {

    private static AppController instance;
    private ConsoleApp consoleApp;

    private AppController() {
    }

    public static AppController getInstance() {
        if (instance == null) {
            synchronized (AppController.class) {
                if (instance == null) {
                    instance = new AppController();
                }
            }
        }
        return instance;
    }

    public void run() {

        consoleApp = ConsoleApp.getConsoleApp();
        consoleApp.call();
        ConsoleUtils.closeScanner();
    }
}
