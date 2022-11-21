package com.example.databaseassignment.diseasetype;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseTypeServiceImpl implements DiseaseTypeService{

    private DiseaseTypeRepository diseaseTypeRepository;

    public DiseaseTypeServiceImpl(DiseaseTypeRepository diseaseTypeRepository) {
        this.diseaseTypeRepository = diseaseTypeRepository;
    }

    @Override
    public List<DiseaseType> getAllDiseaseTypes() {
        return diseaseTypeRepository.findAll();
    }

    @Override
    public DiseaseType saveDiseaseType(DiseaseType diseaseType) {
        return diseaseTypeRepository.save(diseaseType);
    }

    @Override
    public DiseaseType getDiseaseTypeById(Long Id) {
        return diseaseTypeRepository.findById(Id).get();
    }

    @Override
    public DiseaseType updateDiseaseType(DiseaseType diseaseType) {
        return diseaseTypeRepository.save(diseaseType);
    }

    @Override
    public void deleteDiseaseTypeById(Long id) {
        diseaseTypeRepository.deleteById(id);

    }
}
