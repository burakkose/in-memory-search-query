package net.koseburak.sample;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int age;
    private final String name;
    private final Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(name:" + name + ", age:" + age + ", sex:" + gender.name().toLowerCase() + ")";
    }

    public enum Gender {
        MALE, FEMALE;
    }

}