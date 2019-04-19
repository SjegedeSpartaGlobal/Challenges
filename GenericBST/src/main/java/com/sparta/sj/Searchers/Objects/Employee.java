package com.sparta.sj.Searchers.Objects;


public class Employee implements Comparable<Employee>{

    private int age;
    private String name;

    public Employee(int age, String name) {
        this.age = age;
        this.name = name;
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
    public int compareTo(Employee emp){
        if (this.age > emp.getAge()) {
            return 1;
        } else if (this.age < emp.getAge()) {
            return -1;
        }
        return 0;
    }



}
