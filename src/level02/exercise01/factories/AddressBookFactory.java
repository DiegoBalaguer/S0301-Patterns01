package level02.exercise01.factories;

import level02.exercise01.exceptions.CountryNotFoundException;
import level02.exercise01.interfaces.Address;
import level02.exercise01.interfaces.ContactFactory;
import level02.exercise01.interfaces.PhoneNumber;
import level02.exercise01.model.Contact;

public class AddressBookFactory {

    private final ContactFactory contactFactory;

    public AddressBookFactory(String country) throws CountryNotFoundException {
        contactFactory = switch (country.toUpperCase()) {
            case "SP" -> new SpainContactFactory();
            case "USA" -> new UsaContactFactory();
            default -> throw new CountryNotFoundException();
        };
    }

    public Contact getNewContact(String name, String street, String city, String postalCode, String country, String phoneNumber) {
        Address newAddress = contactFactory.createAddress(street, city, postalCode, country);
        PhoneNumber newPhoneNumber = contactFactory.createPhoneNumber(phoneNumber);
        return new Contact(name, newAddress, newPhoneNumber);
    }
}
