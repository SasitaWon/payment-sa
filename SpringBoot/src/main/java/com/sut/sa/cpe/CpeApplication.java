package com.sut.sa.cpe;

import lombok.Data;
import com.sut.sa.cpe.entity.*;
import com.sut.sa.cpe.repository.*;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

import java.util.Date;
@SpringBootApplication
@Data
public class CpeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeApplication.class, args); }

        @Bean
        ApplicationRunner init(PatientRepository patientRepository,ClinicStaffRepository clinicStaffRepository,
                               MedicineRepository medicineRepository,MedicalRecordRepository medicalRecordRepository){

            return args -> {
                Patient patient = new Patient();
                Patient patient1 = new Patient();
                patient.setNamePatient("ปรีชา");
                patient.setPhone("082-4178931");
                patient1.setNamePatient("เทศกิจ");
                patient1.setPhone("052-4856935");
                patientRepository.save(patient);
                patientRepository.save(patient1);

                ClinicStaff clinicStaff = new ClinicStaff();
                ClinicStaff clinicStaff1 = new ClinicStaff();
                clinicStaff.setNameStaff("ตู่");
                clinicStaff.setPassword("C1");
                clinicStaff1.setNameStaff("เปรม");
                clinicStaff1.setPassword("C2");
                clinicStaffRepository.save(clinicStaff);
                clinicStaffRepository.save(clinicStaff1);

                Medicine medicine = new Medicine();
                Medicine medicine1 = new Medicine();
                Medicine medicine2 = new Medicine();
                Medicine medicine3 = new Medicine();
                Medicine medicine4 = new Medicine();

                medicine.setNameMedicine("ยาพารา");
                medicine.setTypeMedicine("เม็ด");
                medicine.setAmountMedicine(9);
                medicine.setPriceMedicine(99);

                medicine1.setNameMedicine("ยาแก้ไอ");
                medicine1.setTypeMedicine("น้ำ");
                medicine1.setAmountMedicine(18);
                medicine1.setPriceMedicine(89);

                medicine2.setNameMedicine("ยาแก้ปวด");
                medicine2.setTypeMedicine("เม็ด");
                medicine2.setAmountMedicine(2);
                medicine2.setPriceMedicine(5);

                medicine3.setNameMedicine("ยาแก้ไข้");
                medicine3.setTypeMedicine("เม็ด");
                medicine3.setAmountMedicine(87);
                medicine3.setPriceMedicine(95);

                medicine4.setNameMedicine("ยาลดน้ำมูก");
                medicine4.setTypeMedicine("น้ำ");
                medicine4.setAmountMedicine(11);
                medicine4.setPriceMedicine(54);

                medicineRepository.save(medicine);
                medicineRepository.save(medicine1);
                medicineRepository.save(medicine2);
                medicineRepository.save(medicine3);
                medicineRepository.save(medicine4);

                MedicalRecord medicalRecord = new MedicalRecord();
                MedicalRecord medicalRecord1 = new MedicalRecord();
                MedicalRecord medicalRecord2 = new MedicalRecord();

                medicalRecord.setIdMedR("1");
                medicalRecord.setNameMedR("ยาพารา");
                medicalRecord.setTypeMedR("เม็ด");
                medicalRecord.setAmountMedR(5);

                medicalRecord1.setIdMedR("1");
                medicalRecord1.setNameMedR("ยาแก้ไอ");
                medicalRecord1.setTypeMedR("น้ำ");
                medicalRecord1.setAmountMedR(4);

                medicalRecord2.setIdMedR("1");
                medicalRecord2.setNameMedR("ยาปวดหัว");
                medicalRecord2.setTypeMedR("เม็ด");
                medicalRecord2.setAmountMedR(6);

                medicalRecordRepository.save(medicalRecord);
                medicalRecordRepository.save(medicalRecord1);
                medicalRecordRepository.save(medicalRecord2);


            };
    }
}