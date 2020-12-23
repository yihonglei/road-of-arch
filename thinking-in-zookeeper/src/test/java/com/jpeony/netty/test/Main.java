package com.jpeony.netty.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("C", 21));
        people.add(new Person("T", 20));
        people.add(new Person("B", 35));
        people.add(new Person("A", 22));
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(System.out::println);
    }
}
class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){
        return this.name + " (" + this.age + ")";
    }
}

