package level02.exercise01.interfaces;

/**
 * PROGRAM: ContactFactory
 * AUTHOR: Diego Balaguer
 * DATE: 01/06/2025
 */

public interface ContactFactory {
    Address createAddress(String street, String city, String postalCode, String country);
    PhoneNumber createPhoneNumber(String phoneNumber);
}

