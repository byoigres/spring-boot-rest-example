package com.neoris.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by sergio.angulo on 22/02/2017.
 */

@Entity
public class Pie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    public Pie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Pie() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



}
