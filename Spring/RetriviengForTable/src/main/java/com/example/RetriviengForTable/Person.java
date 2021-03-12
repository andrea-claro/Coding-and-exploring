package com.example.RetriviengForTable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    Long personalCode;

    /* personal data */
    String nome;
    int yo; //years old

    /* retrieving data */
    String email;
    String phoneNumber;

    public Person() {
    }

    public Person(String nome, int yo, String email, String phoneNumber) {
        this.nome = nome;
        this.yo = yo;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getNome() {
        return nome;
    }

    public int getYo() {
        return yo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setYo(int yo) {
        this.yo = yo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(Long personalCode) {
        this.personalCode = personalCode;
    }

    public String toString() {
        return "Name: " + this.nome + "\nyo: " + yo + "\nemail: " + email + "\nphoneNumber: " + phoneNumber;
    }
}
