package level02.exercise01.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    public void showContacts() {
        contacts.forEach(contact -> {
            contact.getName();
            contact.getAddress().getFullAddress();
            contact.getPhoneNumber().getFormattedNumber();
        });
    }
}
