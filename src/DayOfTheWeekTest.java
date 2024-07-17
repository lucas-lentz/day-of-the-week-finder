import java.util.Scanner;

public class DayOfTheWeekTest {
    public static void main(String[] args) {

        // 1.0 version of the code.
        // Doesn't have any method or OOP.
        // Code was not cleaned for now.

        Scanner read = new Scanner(System.in);
        System.out.println("Type in the day, month and year in the format [DDMMYYYY] :");
        String data = read.nextLine();

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

        int day = Integer.parseInt(dia);
        int month = Integer.parseInt(mes);
        int year = Integer.parseInt(ano);

        int diaEfetivo = 0; // Lops from day 1 in 01-01-1900 until the read "date" day

        // Checking how many effective days there are in the year

        for (int primeiroAno = 1900; primeiroAno < year; primeiroAno++) {

            if ((primeiroAno % 4 == 0 && primeiroAno % 100 != 0) || primeiroAno % 400 == 0) {
                diaEfetivo += 366; // If leap year
            } else {
                diaEfetivo += 365;
            }
        }

        // Effective days on the month:

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

            read.close();
        }

        diaEfetivo += (day - 1);

        // Checking which day of the week it is:

        int resto = (diaEfetivo % 7);

        switch (resto) {
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

}
