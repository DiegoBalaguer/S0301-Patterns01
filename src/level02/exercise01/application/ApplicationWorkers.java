package level02.exercise01.application;

import level02.exercise01.abstractFactories.AddressBookFactory;
import level02.exercise01.exceptions.CountryNotFoundException;
import level02.exercise01.model.AddressBook;
import level02.exercise01.model.Contact;
import utils.ConsoleUtils;
import utils.StringUtils;

import java.util.ArrayList;

public class ApplicationWorkers {

    private static AddressBook addressBook;

    public ApplicationWorkers(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public void createContact() {
        String country = inputCountry();
        try {
            AddressBookFactory factory = new AddressBookFactory(country);
            Contact newContact = factory.getNewContact(inputName(), inputStreet(), inputCity(), inputPostalCode(), country, inputPhone());
            addressBook.addContact(newContact);
        } catch (CountryNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void showListContacts() {
        addressBook.showContacts();
        System.out.println(System.lineSeparator() + "ADDRESSBOOK LIST WITH ID..................");

        System.out.println(makeHeadLineContacts());
        for (Contact contact : addressBook.getContacts()) {
            System.out.println(makeLineContacts(contact.listContact()));
        }
    }

    private String makeHeadLineContacts() {
        ArrayList<String> dataLine = new ArrayList<>();

        dataLine.add("Name");
        dataLine.add("Address");
        dataLine.add("PhoneNumber");

        return makeLineContacts(dataLine);
    }

    private String makeLineContacts(ArrayList<String> dataLine) {
        int i = 0;

        return StringUtils.formatToChars(dataLine.get(i++), 15) + " \t " +
                StringUtils.formatToChars(dataLine.get(i++), 50) + " \t " +
                StringUtils.formatToChars(dataLine.get(i), 10);
    }


    private String inputName() {
        return ConsoleUtils.readRequiredString("Enter name: ");
    }

    private String inputStreet() {
        return ConsoleUtils.readRequiredString("Enter address: ");
    }

    private String inputCity() {
        return ConsoleUtils.readRequiredString("Enter city: ");
    }

    private String inputPostalCode() {
        return ConsoleUtils.readRequiredString("Enter postal code: ");
    }

    private String inputCountry() {
        return ConsoleUtils.readRequiredString("Enter country (SP / USA): ");
    }

    private String inputPhone() {
        return ConsoleUtils.readRequiredString("Enter phone: ");
    }
}
