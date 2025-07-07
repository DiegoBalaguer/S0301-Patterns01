package level02.exercise01.factories;


import level02.exercise01.interfaces.PhoneNumber;

public class SpainPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    public SpainPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFormattedNumber() {
        return "+34 " + phoneNumber;
    }
}