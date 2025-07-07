package level02.exercise01.factories;

import level02.exercise01.interfaces.PhoneNumber;

public class UsaPhoneNumber implements PhoneNumber {
    private String phoneNumber;

    public UsaPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getFormattedNumber() {
        return "+1 " + phoneNumber;
    }
}
