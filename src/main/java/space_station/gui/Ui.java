package space_station.gui;

import java.util.Scanner;

public class Ui {
    public void showMenu() {
        System.out.println("Hello, check what the space station is doing now.");
        System.out.println("1 - You will know the speed of the ISS");
        System.out.println("2 - See the number of people in space as part of the ISS");
        System.out.println("3 - Finish the program");
    }

    public int getUserChoice() {
        System.out.println("Choose what you want to do:");
        Scanner myScanner = new Scanner(System.in);
        int userChoice = myScanner.nextInt();
        return userChoice;
    }
}
