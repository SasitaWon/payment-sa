package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4500")
public interface MedicineRepository extends JpaRepository<Medicine,Long> {

}
