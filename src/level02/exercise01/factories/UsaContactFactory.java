package level02.exercise01.factories;

import level02.exercise01.interfaces.ContactFactory;
import level02.exercise01.interfaces.Address;
import level02.exercise01.interfaces.PhoneNumber;

public class UsaContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String street, String city, String postalCode, String country) {
        return new UsaAddress(street, city, postalCode, country);
    }

    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new UsaPhoneNumber(phoneNumber);
    }
}