package pl.sda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DatesExercise {
    /**
     * 1. Napisz funkcję mapToDate(String date), która dostanie jako parametr date w formacie dd.MM.yyyy i zwroci LocalDate
     * 2. Napisz funkcję mapToDateTime(String dateTime), która dostanie jako parametr date w formacie dd.MM.yyyy HH:mm i zwroci LocalDateTime
     * 3. Napisz funkcje isMondayToday(LocalDate day), która sprawdzi czy podany dzień to poniedziałek
     * 4. Napisz funkcję howLongAgoWasTheBattle(), która sprawdzi jak dawno była bitwa pod grunwaldem - powinna zwrócić ilość dni (int)
     * 5. Napisz funkcję scanIfAdult(), która poprosi o wprowadzenie daty urodzin i jeśli osoba jest pełnoletnia zwróci true, a jeśli nie false
     * 6. Napisz funkcję dayOfTheWeek100DaysAgo(), która sprawdzi jaki dzień tygodnia był 100 dni temu
     */
    public static void main(String[] args) {
        //1
        System.out.println("1.");
        LocalDate localDate = mapToDate("01.10.2091");
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate);
        //2 na piechote, ale lepiej zrobic to przy pomocy DateTimeFormatter
        System.out.println("2.");
        LocalDateTime localDateTime = mapToDateTimeManual("01.01.2001 10:50");
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime);
        //2 z DateTimeFormatter
        System.out.println("2.");
        System.out.println(mapToDateTime("01.01.2001 10:50"));
        //3
        System.out.println("3.");
        System.out.println(checkIsMonday(LocalDate.of(2020, 6, 1)));
        //4
        System.out.println("4.");
        System.out.println(howLongAgoWasTheBattle());
        //5 lepiej nie formatowac daty na piechote :)
        System.out.println("5.");
        //scanIfAdultManual();
        //5
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanIfAdult(scanner.nextLine()));
        //6
        System.out.println("6.");
        System.out.println(dayOfTheWeek100DaysAgo());

    }

    public static DayOfWeek dayOfTheWeek100DaysAgo() {
        LocalDate hundredDaysAgo = LocalDate.now().minusDays(100);
        return hundredDaysAgo.getDayOfWeek();
    }

    public static LocalDate mapToDate(String date) {
        //01.10.2091
        //dd.MM.yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalDateTime mapToDateTime(String date) {
        //01.10.2091 10:50
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return LocalDateTime.parse(date, formatter);
    }

    public static LocalDateTime mapToDateTimeManual(String dateTime) {
        //01.01.2001 10:50
        String[] tablicaDatyCzasy = dateTime.split(" ");
        String[] tablicaDaty = tablicaDatyCzasy[0].split("\\.");
        int day = Integer.parseInt(tablicaDaty[0]);
        int month = Integer.parseInt(tablicaDaty[1]);
        int year = Integer.parseInt(tablicaDaty[2]);
        LocalDate sformatowanaData = LocalDate.of(year, month, day);
        String[] tablicaGodziny = tablicaDatyCzasy[1].split(":");
        int hour = Integer.parseInt(tablicaGodziny[0]);
        int minutes = Integer.parseInt(tablicaGodziny[1]);
        LocalTime sformatowanyCzas = LocalTime.of(hour, minutes);
        LocalDateTime sformatowanyDataCzas = LocalDateTime.of(sformatowanaData, sformatowanyCzas);
        return sformatowanyDataCzas;
    }

    //3
    static boolean checkIsMonday(LocalDate date) {
        DayOfWeek monday = DayOfWeek.MONDAY;
        return monday.equals(date.getDayOfWeek());
    }

    public static int howLongAgoWasTheBattle() {
        LocalDate today = LocalDate.now();
        LocalDate grundwald = LocalDate.of(1410, 7, 15);
        return (int) ChronoUnit.DAYS.between(grundwald, today);
    }

    public static void scanIfAdultManual() {
        LocalDate dzisiaj = LocalDate.now();
        Scanner mojSkaner = new Scanner(System.in);
        System.out.println("5. Wprowadz swoją date urodzin w formacie RRRR-MM-DD: ");
        String dataUrodzenia = mojSkaner.nextLine();
        String[] tablicaDaty = dataUrodzenia.split("-");
        int dzienUrodzenia = Integer.parseInt(tablicaDaty[2]);
        int miesiacUrodzenia = Integer.parseInt(tablicaDaty[1]);
        int rokUrodzenia = Integer.parseInt(tablicaDaty[0]);
        LocalDate sformatowanaData = LocalDate.of(rokUrodzenia, miesiacUrodzenia, dzienUrodzenia);
        long lata = sformatowanaData.until(dzisiaj, ChronoUnit.YEARS);
        if (lata >= 18) {
            System.out.println("Masz " + lata + " lat! Jestes osobą pełnolenią.");
        } else {
            System.out.println("Masz " + lata + " lat! Nie masz jeszcze 18-tu lat.");
        }
    }

    public static boolean scanIfAdult(String dateOfBirthString) {
        //yyyy-MM-dd to DateTimeFormatter.BASIC_ISO_DATE
        LocalDate birthDate = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        long yearsBetweenDateOfBirthAndNow = birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
        return yearsBetweenDateOfBirthAndNow > 18;
    }
}