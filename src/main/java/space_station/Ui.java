package space_station;

import java.util.Scanner;

public class Ui {

    public void showMenu() {
            System.out.println("Witaj, sprawdź co robi teraz stacja kosmiczna.");
            System.out.println("1 - Poznasz prędkość ISS");
            System.out.println("2 - Zobacz liczbę osób przebywąjących w kosmosie w ramach ISS");
            System.out.println("3 - Zakończ program");
        }

        public int getUserChoice(){
            System.out.println("Wybierz co chcesz zrobić:");
            Scanner myScanner = new Scanner(System.in);
            int userChoice = myScanner.nextInt();
            return userChoice;
    }


}
