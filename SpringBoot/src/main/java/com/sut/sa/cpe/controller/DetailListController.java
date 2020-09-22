package com.sut.sa.cpe.controller;

import com.sut.sa.cpe.repository.*;
import com.sut.sa.cpe.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
public class DetailListController {

    @Autowired
    private DetailListRepository detailListRepository;
    @Autowired
    private MedicineRepository medicineRepository;



    @GetMapping(path = "Medicine",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Medicine> Medcine(){
        return medicineRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/Medicine/{id}")
    public Optional<Medicine> medicine(@PathVariable Long id){
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine;
    }







}
