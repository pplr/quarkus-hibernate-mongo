package org.acme.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "helloSequence")
    private Integer id;


    @Column(length = 40, unique = true)
    private String name;

    public Hello() {
    }

    public Hello(final String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}