package net.koseburak.sample;

import java.util.LinkedList;
import java.util.List;

public class Person {

    private int age;
    private String name;
    private Gender gender;
    private List<Person> friends;


    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.friends = new LinkedList<Person>();
    }

    public Person(String name, int age, Gender gender, List<Person> friends) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.friends = friends;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(name:" + name + ", age:" + age + ", sex:" + gender.name().toLowerCase() + ")";
    }

    public enum Gender {
        MALE, FEMALE;
    }


}