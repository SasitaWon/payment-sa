package com.sut.sa.cpe.entity;

import javax.persistence.*;
import javax.persistence.GenerationType;
import  lombok.*;

@Entity
@Data
@Table(name="DetailList")
public class DetailList {

    @Id
    @SequenceGenerator(name = "dl_seq",sequenceName = "dl_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dl_seq")
    @Column(name = "idDL")
    private @NonNull Long id;



    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Payment.class)
    @JoinColumn(name = "IDPayment")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Medicine.class)
    @JoinColumn(name = "IDMedicine")
    private Medicine medicine;



    public DetailList(Long id,Payment payment,Medicine medicine){
        this.payment = payment;
        this.medicine = medicine ;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
    }
    public Payment getPayment(){
        return payment;
    }

    public void setMedicine(Medicine medicine){
        this.medicine = medicine ;
    }
    public Medicine getMedicine(){
        return medicine;
    }
}
