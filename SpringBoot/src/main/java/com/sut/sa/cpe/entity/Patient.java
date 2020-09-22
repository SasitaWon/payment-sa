package com.sut.sa.cpe.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Data
@Table(name="Patient")
public class Patient {

    @Id
    @SequenceGenerator(name = "patient_seq",sequenceName = "patient_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patient_seq")
    private @NonNull Long id;
    private @NonNull String namePatient;
    private  String phone;

    public Patient(){}

    public Patient(Long id,String namePatient,String phone){
        this.namePatient = namePatient;
        this.phone = phone;
    }

    public void setNamePatient(String namePatient){
        this.namePatient =namePatient;
    }
    public String getNamePatient(){
        return namePatient;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getIdPatient(){ return phone;}

}
