package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.District;
import com.tchandak.instranate.domain.School;
import com.tchandak.instranate.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DistrictController {

    public DistrictController(DistrictService districtService){
        this.districtService = districtService;
    }

    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "/api/district/{id}", method = RequestMethod.GET)
    public District getDistrict(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        District districtById = getDistrictById(id);
        return districtById;
    }


    @RequestMapping(value = "/api/district")
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }

    public District getDistrictById(Integer id) {
        return districtService.getDistrictById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/district")
    public void addDistrict(@RequestBody District district) {
        districtService.addDistrict(district);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/district/{id}")
    public void updateDistrict(@RequestBody District district, @PathVariable Integer id) {
        districtService.updateDistrict(id, district);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/district/{id}")
    public void deleteDistrict(@PathVariable Integer id) {
        districtService.deleteDistrict(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/district/usernames")
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        List<District> allDistricts = districtService.getAllDistricts();

        for(int i = 0; i < allDistricts.size(); i++) {
            usernames.add(allDistricts.get(i).getUsername());
        }

        return usernames;
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/api/district/{id}/schools")
//    public List<School> getAllSchools(@PathVariable Integer id) {
//        List<School> returnList = new ArrayList<>();
//        List<School> allSchools = schoolController.getAllSchools();
//
//        for (int i = 0; i < allSchools.size(); i++) {
//            if(allSchools.get(i).getDistrictId() == id) {
//                returnList.add(allSchools.get(i));
//            }
//        }
//
//        return returnList;
//    }
}

