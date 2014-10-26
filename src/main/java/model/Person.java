package model;

import java.util.Arrays;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;

    private int age;
    private String nationality;

    public Person(String firstName, String lastName, int age, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public static List<Person> getPersons() {

        return Arrays.asList(new Person("Francesco", "Abbate", 33, "Italian"),
                             new Person("Francesco", "Gini", 27, "Italian"),
                             new Person("Paul", "Mellor", 35, "English"),
                             new Person("Henrique", "Castro", 27, "Portuguese"),
                             new Person("Neil", "Ferguson", 35, "Irish"),
                             new Person("Suzanne", "Weller", 35, "Irish"),
                             new Person("Facundo", "Bellosi", 33, "Argentinian"),
                             new Person("Roi", "Amir", 40, "Israelian"));
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
