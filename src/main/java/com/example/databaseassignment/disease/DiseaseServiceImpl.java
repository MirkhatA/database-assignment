package com.example.databaseassignment.disease;


import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DiseaseServiceImpl implements DiseaseService{
    private DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Disease> getAllDiseases() {
        return diseaseRepository.findAll();
    }

    @Override
    public Disease saveDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public Disease getDiseaseById(String cname) {
        return diseaseRepository.findById(cname).get();
    }

    @Override
    public Disease updateDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public void deleteDiseaseById(String cname) {
        diseaseRepository.deleteById(cname);

    }
}

