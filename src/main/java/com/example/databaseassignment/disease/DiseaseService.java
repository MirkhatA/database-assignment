package com.example.databaseassignment.disease;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface DiseaseService {

    List<Disease> getAllDiseases();

    Disease saveDisease(Disease disease);

    Disease getDiseaseById(String Id);

    Disease updateDisease(Disease disease);

    void deleteDiseaseById(String id);
}
