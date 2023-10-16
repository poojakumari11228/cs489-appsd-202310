package com.example.Service.Impl;

import com.example.Service.DentistService;

import com.example.Service.PatientService;
import com.example.entity.Patient;
import com.example.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    @Autowired
    PatientServiceImpl(PatientRepo patientRepo){
        this.patientRepo = patientRepo;
    }


    @Override
    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepo.findByEmail(email).orElse(new Patient());
    }
}
