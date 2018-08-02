package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Faculty;
import com.tchandak.instranate.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Faculty> getAllFacultys() {
        List<Faculty> facultys = new ArrayList<>();
        facultyRepository.findAll()
                .forEach(facultys::add);
        return facultys;
    }

    public Faculty getFacultyById(Integer id) {

        //return facultys.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return facultyRepository.findOne(id);
    }

    public void addFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void updateFaculty(Integer id, Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void deleteFaculty(Integer id) {
        facultyRepository.delete(id);
    }
}
