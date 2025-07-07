package level02.exercise01.application;

import level02.exercise01.enums.OptionsMenuMain;
import level02.exercise01.model.AddressBook;
import utils.ConsoleUtils;

/**
 * PROGRAM: ApplicationController
 * AUTHOR: Diego Balaguer
 * DATE: 01/06/2025
 */

public class ApplicationController {

    private static AddressBook addressBook;
    private ApplicationWorkers applicationManager;

    public void run() {
        addressBook = new AddressBook();
        applicationManager = new ApplicationWorkers(addressBook);
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
            case CONTACT_CREATE -> applicationManager.createContact();
            default -> {
                if (addressBook.isEmpty()) {
                    System.out.println("No contacts registered into the system.");
                } else menuOptionsWithAddresses(idMenu);
            }
        }
    }

    private void menuOptionsWithAddresses(OptionsMenuMain idMenu) {
        switch (idMenu) {
            case CONTACT_LIST -> applicationManager.showListContacts();
            default -> System.out.println("Error: The value is wrong.");
        }
    }
}
