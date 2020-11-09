
package com.example.demo.entities;

import lombok.Data;

@Data
public class Person {
    
    private String id, nama, gender;
    private int age;

    public Person() {
    }

    public Person(String id, String nama, String gender, int age) {
        this.id = id;
        this.nama = nama;
        this.gender = gender;
        this.age = age;
    }
    
    
}
