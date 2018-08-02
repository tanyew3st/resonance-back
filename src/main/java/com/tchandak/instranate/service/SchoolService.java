package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.School;
import com.tchandak.instranate.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schoolRepository.findAll()
                .forEach(schools::add);
        return schools;
    }

    public School getSchoolById(Integer id) {

        //return donors.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return schoolRepository.findOne(id);
    }

    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    public void updateSchool(Integer id, School school) {
        schoolRepository.save(school);
    }

    public void deleteSchool(Integer id) {
        schoolRepository.delete(id);
    }




}
