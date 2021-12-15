package net.yorksolutions.jsontest.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String text;

    public ToDo(String text) {
        this.text = text;
    }

    //default constructor, once you specify a constructor then need to specify the default too
    public ToDo() {

    }
}
