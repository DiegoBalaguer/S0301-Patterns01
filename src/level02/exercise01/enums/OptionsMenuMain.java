package level02.exercise01.enums;

/**
 * PROGRAM: OptionsMenuMain
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public enum OptionsMenuMain {

    CONTACT_CREATE("Create contact"),
    CONTACT_LIST("List contacts"),
    EXIT("Exit");

    private final String DESCRIPTION;

    // Constructor del enum
    OptionsMenuMain(String description) {
        this.DESCRIPTION = description;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public static void viewMenu(String title) {
        System.out.println(System.lineSeparator() + title + System.lineSeparator());
        for (OptionsMenuMain optionMenu : OptionsMenuMain.values()) {
            System.out.println(optionMenu.ordinal() + 1 + ". " + optionMenu.getDESCRIPTION());
        }
        System.out.println(System.lineSeparator() + "Choose an option: ");
    }
}
