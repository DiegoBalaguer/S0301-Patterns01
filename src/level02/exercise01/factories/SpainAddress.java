package level02.exercise01.factories;

import level02.exercise01.interfaces.Address;

public class SpainAddress implements Address {
    private String street, city, postalCode, country;

    public SpainAddress(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String getFullAddress() {
        return street + ", " + postalCode + "-" + city + "-" + country;
    }
}



