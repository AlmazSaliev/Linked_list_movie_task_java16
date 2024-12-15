package config;

import java.util.Scanner;

public class CheckValue {
    public static String[] CheckValue(String label, String regex) {
        try {
            System.out.print("Write the " + label + ": ");
            boolean isBool = false;
            String text;
            do {
                text = new Scanner(System.in).nextLine();
                if (!text.matches(regex)) {
                    isBool = false;
                    System.out.printf("Invalid %s. Write the valid %s: ", label, label);
                } else {
                    isBool = true;
                }
            } while (!text.matches(regex));
            String[] value = new String[2];
            value[0] = text;
            value[1] = String.valueOf(isBool);
            return value;
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid value!");
        }
    }

    public static void InvalidValueMessage(int numMessage) {
        switch (numMessage) {
            case 1 -> {
                System.out.println("Successfully added!");
            }
            case 2->{
                System.out.println("Error on added!");
            }
            case 3->{
                System.out.println("Successfully deleted!");
            }
            case 4->{
                System.out.println("Error on deleted!");
            }
            case 5->{
                System.out.println("Invalid value!");
            }
            default -> {
                System.out.println("Error on code!)");
            }
        }
    }
}
