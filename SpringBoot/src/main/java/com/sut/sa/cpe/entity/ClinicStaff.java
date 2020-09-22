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
@Table(name="ClinicStaff")
public class ClinicStaff {

    @Id
    @SequenceGenerator(name = "staff_seq",sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_seq")
    private @NonNull Long id;
    @Column(name = "nameStaff")
    private @NonNull String nameStaff;
    private @NonNull String password;


    public ClinicStaff() {}

    public ClinicStaff(Long id,String nameStaff,String password) {

        this.nameStaff = nameStaff;
        this.password = password ;
    }


    public void setNameStaff(String nameStaff) {

        this.nameStaff = nameStaff;
    }
    public String getNameStaff() {
        return nameStaff;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

}

