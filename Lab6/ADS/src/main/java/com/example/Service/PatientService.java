package com.example.Service;

import com.example.entity.Patient;

import java.util.List;

public interface PatientService {

   void addPatient(Patient patient);
   Patient findByEmail(String email);

}
