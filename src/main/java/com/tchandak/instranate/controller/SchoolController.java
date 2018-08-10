package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Instrument;
import com.tchandak.instranate.domain.School;
import com.tchandak.instranate.service.InstrumentService;
import com.tchandak.instranate.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchoolController {

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @Autowired
    private SchoolService schoolService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/school")
    public void addSchool(@RequestBody School school) {
        schoolService.addSchool(school);
        System.out.println("Just added a school that looks like " + school.getId() + " " + school.getUsername());

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/school/message/{id}")
    public void updateMessage(@RequestBody String message, @PathVariable Integer id) {
        getSchoolById(id).setMessage(message);
        schoolService.updateSchool(id, getSchoolById(id));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/school/usernames")
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        List<School> allSchools = schoolService.getAllSchools();

        for(int i = 0; i < allSchools.size(); i++) {
            usernames.add(allSchools.get(i).getUsername());
        }

        return usernames;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/school/{id}")
    public void updateDonor(@RequestBody School school, @PathVariable Integer id) {
        schoolService.updateSchool(id, school);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/school/{id}", method = RequestMethod.GET)
    public School getSchool(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        School schoolById = getSchoolById(id);
        return schoolById;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/school/district/{id}", method = RequestMethod.GET)
    public List<School> getSchoolsByDistrict(@PathVariable(value = "id") Integer id) {
        List<School> allSchools = schoolService.getAllSchools();
        List<School> returnArray = new ArrayList<>();
        for (int i = 0; i < allSchools.size(); i++) {
            if (allSchools.get(i).getDistrictId() == id) {
                returnArray.add(allSchools.get(i));
            }
        }

        return returnArray;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/school")
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        return schoolService.getSchoolById(id);
    }




}
