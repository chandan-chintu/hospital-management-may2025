package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    // here we are using hashmap to store the data which is in memory
    Map<Integer, Doctor> doctorMapDB = new HashMap<>();
    // 101 -> {101,"Ajay","ajay123@gmail.com","Cardiologist","male"}
    // 102 -> {102,"Vijay","vijay123@gmail.com","Cardiologist","male"}
    // 103 -> {103,"Sanjay","sanjay123@gmail.com","Cardiologist","male"}

    //spring boot application - takes input in the form of JSON(javascript object notation)

    // @RequestBody -it takes the input from the postman or ui and assigns it to the doctor object(used for complete class objects)

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        doctorMapDB.put(doctor.getId(), doctor);
        System.out.println("doctor saved is : "+doctorMapDB);
        return "Doctor saved successfully";
    }

    // @PathVariable - it takes the input in the url path or endpoint
    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorMapDB.get(id);
        return doctor;
    }

    @GetMapping("/findAll")
    public Map<Integer, Doctor> findAllDoctors(){
        return doctorMapDB;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id){
        doctorMapDB.remove(id);
        return "Doctor with id :"+id+" has been deleted";
    }
}
