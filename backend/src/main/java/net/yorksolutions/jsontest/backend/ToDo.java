package net.yorksolutions.jsontest.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    // annotated this one property in todo class as a json property
    // we called our controller a REST controller
    @JsonProperty
    String text;

    public ToDo(String text) {
        this.text = text;
    }

    //default constructor, once you specify a constructor then need to specify the default too
    public ToDo() {

    }
}
