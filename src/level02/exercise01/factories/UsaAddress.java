package level02.exercise01.factories;

import level02.exercise01.interfaces.Address;

public class UsaAddress implements Address {
    private String street, city, postalCode, country;

    public UsaAddress(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFullAddress() {
        return street + ", " + city + "-" + postalCode + "-" + country;
    }
}


