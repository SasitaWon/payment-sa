package com.sut.sa.cpe.repository;

import com.sut.sa.cpe.entity.DetailList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4500")
public interface DetailListRepository extends JpaRepository<DetailList,Long>{

}
