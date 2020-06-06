package pl.sda;

public class PersonList {
    private Person[] listOfPeople = new Person[5];
    private int amountOfPeople;

    public void addPerson(Person person) {
        listOfPeople[amountOfPeople] = person;
        amountOfPeople++;
    }

    public Person[] getListOfPeople() {
        return listOfPeople;
    }
}
