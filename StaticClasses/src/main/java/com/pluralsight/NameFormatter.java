package com.pluralsight;

public class NameFormatter {

    // Private constructor to prevent instantiation
    private NameFormatter() {}

    // Format with first name and last name only
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // Format with all components
    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        StringBuilder formattedName = new StringBuilder();
        formattedName.append(lastName + ", ");
        if (!prefix.isEmpty()) {
            formattedName.append(prefix + " ");
        }
        formattedName.append(firstName);
        if (!middleName.isEmpty()) {
            formattedName.append(" " + middleName);
        }
        if (!suffix.isEmpty()) {
            formattedName.append(", " + suffix);
        }
        return formattedName.toString();
    }

    // Format with full name input
    public static String format(String fullName) {
        String[] parts = fullName.split(", ");
        String suffix = (parts.length > 1) ? parts[1] : "";
        String[] nameParts = parts[0].split(" ");
        String prefix = nameParts[0].endsWith(".") ? nameParts[0] : "";
        String firstName = prefix.isEmpty() ? nameParts[0] : nameParts[1];
        String middleName = (nameParts.length == 4) ? nameParts[2] : (nameParts.length == 3) ? nameParts[1] : "";
        String lastName = nameParts[nameParts.length - 1];

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}