package com.sut.sa.cpe.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.GenerationType;


import java.awt.*;
import java.util.Date;
import java.sql.Timestamp;

import java.util.List;

@Data
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_seq",sequenceName = "payment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payment_seq")

    @Column(name = "idPayment")
    private @NonNull   Long id;


    private @NonNull Timestamp date;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Patient.class)
    @JoinColumn(name = "IDPatient")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ClinicStaff.class)
    @JoinColumn(name = "IDStaff")
    private ClinicStaff clinicStaff;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDMedR")
    private MedicalRecord medicalRecord;





    public Payment(){}

    public Payment(Long id,Timestamp date,Patient patient,ClinicStaff clinicStaff,MedicalRecord medicalRecord){

        this.date = date;
        this.patient = patient;
        this.clinicStaff = clinicStaff;
        this.medicalRecord = medicalRecord;
    }


    public void setTime(Timestamp date){
        this.date = date;
    }
    public Timestamp getDate(){
        return date;
    }

    public void setPatient(Patient patient) {this.patient = patient;}
    public Patient getPatient(){ return patient;}

    public void setClinicStaff(ClinicStaff clinicStaff){ this.clinicStaff = clinicStaff;}
    public ClinicStaff getClinicStaff(){ return clinicStaff; }

    public void setMedicineRecord (MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord;}
    public MedicalRecord getMedicalRecord() {return medicalRecord;}

}
