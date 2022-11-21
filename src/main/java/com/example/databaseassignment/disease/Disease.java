package com.example.databaseassignment.disease;

import com.example.databaseassignment.diseasetype.DiseaseType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table

public class Disease {

    @Id
    private String diseaseCode;

    private String pathogen;

    private String description;

    private Long id;

    @ManyToMany
    private List<DiseaseType> diseaseTypeForeign;


    public Disease() {
    }

    public Disease(String diseaseCode, String pathogen, String description, Long id, List<DiseaseType> diseaseTypeForeign) {
        this.diseaseCode = diseaseCode;
        this.pathogen = pathogen;
        this.description = description;
        this.id = id;
        this.diseaseTypeForeign = diseaseTypeForeign;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DiseaseType> getDiseaseTypeForeign() {
        return diseaseTypeForeign;
    }

    public void setDiseaseTypeForeign(List<DiseaseType> diseaseTypeForeign) {
        this.diseaseTypeForeign = diseaseTypeForeign;
    }
}
