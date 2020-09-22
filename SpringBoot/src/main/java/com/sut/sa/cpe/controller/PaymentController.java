package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.repository.*;
import com.sut.sa.cpe.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Optional;
import java.sql.Timestamp;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
public class PaymentController {
    @Autowired
    private PaymentRepository payRepo;
    @Autowired
    private ClinicStaffRepository staffRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    @GetMapping("/ClinicStaff/{nameStaff}/{password}")
    public boolean customer1(@PathVariable String nameStaff,@PathVariable String password){
        ClinicStaff user = staffRepo.findByNameStaff(nameStaff);
        String x = user.getPassword();
        System.out.println(nameStaff);
        System.out.println(x + "=" + password);
        return x.matches(password);
    }

    @GetMapping(path = "Payment",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Payment> Payment(){
        return  payRepo.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Payment/{id}")
    public Optional<Payment> payment(@PathVariable Long id){
        Optional<Payment> p = payRepo.findById(id);

        return p;
    }

    @GetMapping(path = "ClinicStaff",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ClinicStaff> ClinicStaff() {
        return staffRepo.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/ClinicStaff/{id}")
    public Optional<ClinicStaff> clinicStaff(@PathVariable Long id){
        Optional<ClinicStaff>
                c = staffRepo.findById(id);
        return c;
    }

    @GetMapping(path = "Patient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Patient> Patient() {
        return patientRepo.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Patient/{id}")
    public Optional<Patient> patient(@PathVariable Long id)  {
        Optional<Patient> pat = patientRepo.findById(id);
        return pat;
    }

    @GetMapping(path = "MedicalRecord", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<MedicalRecord> MedicalRecord() {
        return medicalRecordRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/MedicalRecord/{id}")
    public Optional<MedicalRecord> medicalRecord(@PathVariable Long id)  {
        Optional<MedicalRecord> med = medicalRecordRepository.findById(id);
        return med;
    }



    @PostMapping(path ="/Payment/{nameStaffSelect}/{namePatientSelect}")
    @CrossOrigin(origins = "http://localhost:4500")
    public Payment payment(
            @PathVariable  Long nameStaffSelect,
            @PathVariable  Long namePatientSelect,
            @RequestBody   MedicalRecord medicalRecord


            ){

        ClinicStaff clinicStaff = staffRepo.findById(nameStaffSelect).get();
        Patient patient = patientRepo.findById(namePatientSelect).get();





        Payment payment = new Payment();
        payment.setClinicStaff(clinicStaff);
        payment.setPatient(patient);



        payment.setTime(new Timestamp(System.currentTimeMillis()));


        payRepo.save(payment);
        return payment;
    }


}
