package models;

// Uses the scanner object to read the user input.
// Later on: can put the treatment of what's being inputted here
// So that the user doesn't type anything different than numbers
// Then, check if application receives a String is on the format [DDMMYYYY]

import java.util.Scanner;

public class UserInterface {
    private final Scanner read;

    public UserInterface(Scanner read) {
        this.read = read;
    }

    public String receiveAndValidateDate() {

        String data = "";
        boolean validDateFormat = false; // if true, main app will continue

        while (validDateFormat == false) {
            System.out.println("Type in the day, month and year in the format [DDMMYYYY] :");
            data = read.nextLine();
            try {
                if (data.length() == 8) {
                    int dayInt = Integer.parseInt(data.substring(0, 2));
                    int monthInt = Integer.parseInt(data.substring(2, 4));
                    int yearInt = Integer.parseInt(data.substring(4));

                    // Validate day, month, and year
                    if (dayInt >= 1 && dayInt <= 31 && monthInt >= 1 && monthInt <= 12 && yearInt >= 1900) {
                        validDateFormat = true;
                        return data;
                    } else {
                        System.out.println("Invalid date format!");
                    }
                } else {
                    System.out.println("Invalid date format!");
                }
            } catch (NumberFormatException e) {
                // non-numeric input
                System.out.println("Invalid input! ");
            }
        }
        return data;
    }

}
