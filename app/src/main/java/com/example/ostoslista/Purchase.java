package com.example.ostoslista;

import java.util.Date;

public class Purchase {
    private String name;
    private String description;
    private int age;

    public Purchase(String name, String description){
        this.name = name;
        this.description = description;
        age = setRealAge();
        System.out.println(age);
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int setRealAge() {
        Date date = new Date();
        int age = (int)date.getTime();
        return age;
    }

    public int getAge() {
        return age;
    }
}
