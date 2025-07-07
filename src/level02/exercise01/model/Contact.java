package level02.exercise01.model;

import level02.exercise01.interfaces.Address;
import level02.exercise01.interfaces.PhoneNumber;

import java.util.ArrayList;

public class Contact {
    private String name;
    private Address address;
    private PhoneNumber phoneNumber;


    public Contact(String name, Address address, PhoneNumber phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<String> listContact() {
        ArrayList<String> list = new ArrayList<>();

        list.add(this.name);
        list.add(String.valueOf(this.getAddress().getFullAddress()));
        list.add(String.valueOf(this.getPhoneNumber().getFormattedNumber()));
        return list;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", address=" + getAddress().getFullAddress()  + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
