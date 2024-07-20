package com.example.doctorservice.service;

import com.example.doctorservice.model.Doctor;
import com.example.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        // Asociar pacientes con el doctor
        doctor.getPatients().forEach(patient -> patient.setDoctor(doctor));

        // Guardar el doctor (y sus pacientes asociados)
        return doctorRepository.save(doctor);
    }
}
