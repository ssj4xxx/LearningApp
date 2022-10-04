package com.khoalt.IntroductionEbook.Chap19;

public class Person implements DogAction, Comparable<Person> {
    int age;
    String name;

    public void run(){

    }

    @Override
    public void bark() {

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


    @Override
    public int compareTo(Person o) {
        return ((Integer)age).compareTo(o.getAge());
    }
}
