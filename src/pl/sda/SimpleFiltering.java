package pl.sda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SimpleFiltering {

    private static final String FEMALE = "Female";
    public static final String MALE = "Male";

    /**
     * 1.Stwórz klasę człowiek mającą pola: imię, data urodzenia, płeć (pamiętaj o nadaniu odpowiednich typów i angielskich nazwach):
     * Stwórz tablicę, która będzie zawierała następujące osoby:
     * Adam, data urodzenia 01.01.2022
     * Basia, data urodzenia 01.01.2002
     * Paweł, data urodzenia 01.01.2003
     * Kasia, data urodzenia 01.01.2000
     * Marcin, data urodzenia 01.01.2011
     * Wypisz:
     * a) osobno mężczyzn i osobno kobiety
     * b) osoby pełnoletnie
     * c) wszystkie osoby, których wiek jest wielokrotnością 10
     * d) zsumuj wiek wszystkich osób (ile łącznie mają lat)
     * e) wszystkie osoby mające “si” w imieniu
     */
    public static void main(String[] args) {
        LocalDate dobAdam = LocalDate.of(2022, 1, 1);
        LocalDate dobBasia = LocalDate.of(2002, 1, 1);
        LocalDate dobPawel = LocalDate.of(2003, 1, 1);
        LocalDate dobKasia = LocalDate.of(2000, 1, 11);
        LocalDate dobMarcin = LocalDate.of(2011, 1, 1);
        Person adam = new Person("Adam", dobAdam, MALE);
        Person basia = new Person("Basia", dobBasia, FEMALE);
        Person pawel = new Person("Pawel", dobPawel, MALE);
        Person kasia = new Person("Kasia", dobKasia, FEMALE);
        Person marcin = new Person("Marcin", dobMarcin, MALE);

        PersonList personList = new PersonList();
        personList.addPerson(adam);
        personList.addPerson(basia);
        personList.addPerson(pawel);
        personList.addPerson(kasia);
        personList.addPerson(marcin);
        System.out.println("FEMALES:");
        for (Person person : personList.getListOfPeople()) {
            //to do stalej
            if (person.getSex().equals(FEMALE)) {
                System.out.println(person);
            }
        }
        System.out.println("MALES:");
        for (Person person : personList.getListOfPeople()) {
            //to do stalej
            if (person.getSex().equals(MALE)) {
                System.out.println(person);
            }
        }
        System.out.println("ADULTS:");
        for (Person person : personList.getListOfPeople()) {
            if (DatesExercise.scanIfAdultOtherEx(person.getDateOfBirth())) {
                System.out.println(person);
            }
        }
        System.out.println("PERSONS WHOSE AGES IS MULTIPLY OF 10:");
        for (Person person : personList.getListOfPeople()) {
            LocalDate today = LocalDate.now();
            long age = ChronoUnit.YEARS.between(person.getDateOfBirth(), today);
            if (age % 10 == 0) {
                System.out.println(person);
            }
        }
        System.out.println("SUM OF PEOPLES AGE:");
        int sum = 0;
        for (Person person : personList.getListOfPeople()) {
            LocalDate today = LocalDate.now();
            long age = ChronoUnit.YEARS.between(person.getDateOfBirth(), today);
            if (age > 0) {
                sum = sum + (int) age;
            }
        }
        System.out.println(sum);
        System.out.println("PERSONS WHO HAVE \"si\" LETTERS IN NAME:");
        for (Person person : personList.getListOfPeople()) {
            if (person.getName().contains("si")) {
                System.out.println(person);
            }
        }
    }
}
