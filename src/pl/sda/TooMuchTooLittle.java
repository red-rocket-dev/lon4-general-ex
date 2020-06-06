package pl.sda;

import java.util.Random;
import java.util.Scanner;

public class TooMuchTooLittle {
    /**
     * Gra w za dużo za mało przebiega następująco:
     * 1. Losowana jest liczba od 1-10 - zapamiętaj ją w zmiennej
     * 2. Gracz jest pytany: "Jaka to liczba?"
     * 3. Jeśli podana odpowiedź jest mniejsza od wylosowanej to gra wypisuje: "Za mało"
     * 4. Jeśli podana odpowiedź jest większa od wylosowanej to gra wypisuje: "Za dużo"
     * 5. Jeśli podana odpowiedź jest równa wylosowanej to gra wypisuje: "Gratulacje, wygrana!" i kończy grę.
     */
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = randomGenerator.nextInt(100) + 1;
        System.out.println("Witam w grze Za duzo, Za malo\nPodaj Liczbe od 1 do 100");
        int usersNumber;
        do {
            usersNumber = scanner.nextInt();
            if (usersNumber < randomNumber) {
                System.out.println("Liczba jest za mala");
            } else if (usersNumber > randomNumber) {
                System.out.println("liczba jest za duza");
            }
        } while (randomNumber != usersNumber);
        System.out.println("Wygrales(-as)!!!!:D");
    }
}
