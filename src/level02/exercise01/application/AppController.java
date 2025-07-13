package level02.exercise01.application;

import level02.exercise01.enums.OptionsMenuMain;
import level02.exercise01.model.AddressBook;
import utils.ConsoleUtils;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 01/06/2025
 */

public class AppController {

    private static AddressBook addressBook;
    private static AppController instance;
    private AppWorkers appWorkers;

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
        addressBook = new AddressBook();
        appWorkers = AppWorkers.getInstance(addressBook);
        menu();
        ConsoleUtils.closeScanner();
    }

    private void menu() {
        do {
            OptionsMenuMain.viewMenu("ADDRESS BOOK");
            int answer = ConsoleUtils.readRequiredInt("");
            try {
                OptionsMenuMain idMenu = OptionsMenuMain.values()[answer - 1];
                if (idMenu == OptionsMenuMain.EXIT) {
                    return;
                }
                else menuOptionsWithoutAddresses(idMenu);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: The value is wrong.");
            }
        } while (true);
    }

    private void menuOptionsWithoutAddresses(OptionsMenuMain idMenu) {
        switch (idMenu) {
            case CONTACT_CREATE -> appWorkers.createContact();
            default -> {
                if (addressBook.isEmpty()) {
                    System.out.println("No contacts registered into the system.");
                } else menuOptionsWithAddresses(idMenu);
            }
        }
    }

    private void menuOptionsWithAddresses(OptionsMenuMain idMenu) {
        switch (idMenu) {
            case CONTACT_LIST -> appWorkers.showListContacts();
            default -> System.out.println("Error: The value is wrong.");
        }
    }
}
