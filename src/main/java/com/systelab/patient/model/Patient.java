package com.systelab.patient.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    protected Patient() {
    }

    private Patient(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Patient of(String name, String surname) {
        checkNotNull(name);
        checkNotNull(surname);

        Patient patient = new Patient(name, surname);
        return patient;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Patient)) {
            return false;
        }

        Patient other = (Patient) obj;

        return Objects.equals(other.name, this.name) && Objects.equals(other.surname, this.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }
}