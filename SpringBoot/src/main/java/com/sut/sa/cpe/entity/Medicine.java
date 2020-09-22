package com.sut.sa.cpe.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import lombok.*;

@Entity
@Data
@Table(name="medicine")
public class Medicine {

    @Id
    @SequenceGenerator(name = "medicine_seq",sequenceName = "medicine_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "medicine_seq")
    private @NonNull Long id;

    private @NonNull String nameMedicine;
    private @NonNull String typeMedicine;
    private @NonNull Integer amountMedicine;
    private @NonNull Integer priceMedicine;


    public Medicine () {}

    public Medicine(Long id,String nameMedicine,String typeMedicine,Integer amountMedicine,Integer priceMedicine){
        this.nameMedicine = nameMedicine;
        this.typeMedicine = typeMedicine;
        this.amountMedicine = amountMedicine;
        this.priceMedicine = priceMedicine;
    }

    public void setNameMedicine(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }
    public String getNameMedicine() {
        return nameMedicine;
    }

    public void setTypeMedicine(String typeMedicine) {
        this.typeMedicine = typeMedicine;
    }
    public String getTypeMedicine() {
        return typeMedicine;
    }

    public void setAmountMedicine(Integer amountMedicine){
        this.amountMedicine = amountMedicine;
    }
    public Integer getAmountMedicine(){
        return amountMedicine;
    }

    public void setPriceMedicine(Integer priceMedicine) {
        this.priceMedicine = priceMedicine;
    }
    public Integer getPriceMedicine(){ return priceMedicine; }

}
