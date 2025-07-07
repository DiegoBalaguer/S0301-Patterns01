package level02.exercise01.factories;

import level02.exercise01.interfaces.ContactFactory;
import level02.exercise01.interfaces.Address;
import level02.exercise01.interfaces.PhoneNumber;

public class SpainContactFactory implements ContactFactory {
    @Override
    public Address createAddress(String street, String city, String postalCode, String country) {
        return new SpainAddress(street, city, postalCode, country);
    }

    @Override
    public PhoneNumber createPhoneNumber(String phoneNumber) {
        return new SpainPhoneNumber(phoneNumber);
    }
}
