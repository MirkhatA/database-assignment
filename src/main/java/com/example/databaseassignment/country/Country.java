package com.example.databaseassignment.country;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table

public class Country {

    @Id
    private String cname;
    private Long population;

    public Country() {
    }

    public Country(String cname, Long population) {
        this.cname = cname;
        this.population = population;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
