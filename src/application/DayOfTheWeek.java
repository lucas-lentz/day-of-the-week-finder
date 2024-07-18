package application;

import models.UserInterface;

import java.util.Scanner;

public class DayOfTheWeek {
    public static void main(String[] args) {

        // 1.0 version of the code.
        // Class was renamed
        // Packages application and models were created
        // Object UserInterface handles the user input
        // Methods and object were created to make the code clear

        Scanner read = new Scanner(System.in);
        // Creates the object and validates the user-inputted data
        // Will keep asking for dates until the user types the format DDMMYYYY.
        UserInterface myInterface = new UserInterface(read);
        String data = myInterface.receiveAndValidateDate();

        // With a valid date, check the number of effective days between
        // 01/01/1900 and the input date data.

        int effectiveDays = calculateEffectiveDays(data);

        // Checking which day of the week it is:
        findingTheExactDayOfTheWeek(effectiveDays);
        read.close();
    }


    private static void findingTheExactDayOfTheWeek(int effectiveDays) {
        int remainder = (effectiveDays % 7);

        switch (remainder) {
            case 0:
                System.out.println("Monday");
                break;
            case 1:
                System.out.println("Tuesday");
                break;
            case 2:
                System.out.println("Wednesday");
                break;
            case 3:
                System.out.println("Thursday");
                break;
            case 4:
                System.out.println("Friday");
                break;
            case 5:
                System.out.println("Saturday");
                break;
            case 6:
                System.out.println("Sunday");
                break;
        }
    }

    public static int calculateEffectiveDays(String data) {

        String dia = "";
        String mes = "";
        String ano = "";

        // Breaking the string:

        for (int i = 0; i < data.length(); i++) {
            if (i == 0 || i == 1) {
                dia += data.charAt(i);
            } else if (i == 2 || i == 3) {
                mes += data.charAt(i);
            } else {
                ano += data.charAt(i);
            }
        }

        // Passing from String to int
        // Now we have the exact day, month and year the user typed

        int day = Integer.parseInt(dia);
        int month = Integer.parseInt(mes);
        int year = Integer.parseInt(ano);

        int diaEfetivo = 0; // Lops from day 1 in 01-01-1900, a Monday, until the read "data" day

        // Checking how many effective days there are in the year

        for (int primeiroAno = 1900; primeiroAno < year; primeiroAno++) {

            if ((primeiroAno % 4 == 0 && primeiroAno % 100 != 0) || primeiroAno % 400 == 0) {
                diaEfetivo += 366; // If leap year
            } else {
                diaEfetivo += 365;
            }
        }

        // Effective days on the month:
        // First month = primeiroMes = January. Starts with 1.

        for (int primeiroMes = 1; primeiroMes < month; primeiroMes++) {
            switch (primeiroMes) {
                case 1:
                    diaEfetivo += 31;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        diaEfetivo += 29; // If leap year
                    } else {
                        diaEfetivo += 28;
                    }
                    break;
                case 3:
                    diaEfetivo += 31;
                    break;
                case 4:
                    diaEfetivo += 30;
                    break;
                case 5:
                    diaEfetivo += 31;
                    break;
                case 6:
                    diaEfetivo += 30;
                    break;
                case 7:
                    diaEfetivo += 31;
                    break;
                case 8:
                    diaEfetivo += 31;
                    break;
                case 9:
                    diaEfetivo += 30;
                    break;
                case 10:
                    diaEfetivo += 31;
                    break;
                case 11:
                    diaEfetivo += 30;
                    break;
                case 12:
                    diaEfetivo += 31;
                    break;
            }


        }
        diaEfetivo += (day - 1);
        return diaEfetivo;
    }

}