package pl.sda;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private String sex;

    public Person(String name, LocalDate dateOfBirth, String sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", sex='" + sex + '\'' + '}';
    }
}