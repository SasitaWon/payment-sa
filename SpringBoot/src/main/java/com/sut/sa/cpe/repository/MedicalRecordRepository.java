package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long>{
}
