package com.sut.sa.cpe.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name="MedicalRecord")
public class MedicalRecord {

    @Id
    @SequenceGenerator(name = "medr_seq",sequenceName = "medr_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medr_seq")
    private @NonNull Long id;

    @Column(name = "idMedR")
    private @NonNull String idMedR;
    private @NonNull String nameMedR;
    private @NonNull String typeMedR;
    private @NonNull Integer amountMedR;


    public MedicalRecord(){}

    public MedicalRecord(Long id,String idMedR,String nameMedR,String typeMedR,Integer amountMedR){
        this.idMedR = idMedR;
        this.nameMedR = nameMedR;
        this.typeMedR = typeMedR;
        this.amountMedR = amountMedR;

    }
    public void setIdMedR(String idMedR){ this.idMedR = idMedR; }
    public String getIdMedR(){ return  idMedR; }

    public void setNameMedR(String nameMedR) {
        this.nameMedR = nameMedR;
    }
    public String getNameMedR() {
        return nameMedR;
    }

    public void setTypeMedR(String typeMedR) {
        this.typeMedR = typeMedR;
    }
    public String getTypeMedR() {
        return typeMedR;
    }

    public void setAmountMedR(Integer amountMedR) {
        this.amountMedR = amountMedR;
    }
    public Integer getAmountMedR() {
        return amountMedR;
    }



}
