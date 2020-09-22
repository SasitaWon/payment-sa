package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.ClinicStaff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4500")
public interface ClinicStaffRepository extends JpaRepository<ClinicStaff,Long>{
    ClinicStaff findByNameStaff(String nameStaff);
    ClinicStaff findByPassword(String password);
}
