package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Faculty;
import com.tchandak.instranate.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FacultyController {

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Autowired
    private FacultyService facultyService;

    @CrossOrigin
    @RequestMapping(value = "/api/faculty/{id}", method = RequestMethod.GET)
    public Faculty getFaculty(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Faculty facultyById = getFacultyById(id);
        return facultyById;
    }


    @CrossOrigin
    @RequestMapping(value = "/api/faculty")
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFacultys();
    }

    public Faculty getFacultyById(Integer id) {
        return facultyService.getFacultyById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/faculty")
    public void addFaculty(@RequestBody Faculty faculty) {
        facultyService.addFaculty(faculty);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/faculty/{id}")
    public void updateFaculty(@RequestBody Faculty faculty, @PathVariable Integer id) {
        facultyService.updateFaculty(id, faculty);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/faculty/{id}")
    public void deleteFaculty(@PathVariable Integer id) {
        facultyService.deleteFaculty(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/faculty/get/{schoolId}")
    public List<Faculty> getAllFacultyBySchoolId(@PathVariable Integer schoolId) {
        List<Faculty> returnList = new ArrayList<Faculty>();
        List<Faculty> allFaculty = getAllFaculty();
        for(int i = 0; i < allFaculty.size(); i++) {
            if(allFaculty.get(i).getSchoolId() == schoolId) {
                returnList.add(allFaculty.get(i));
            }
        }

        return returnList;
    }
}