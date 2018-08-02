package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Type;
import com.tchandak.instranate.service.SchoolService;
import com.tchandak.instranate.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeController {

    public TypeController(TypeService typeService, SchoolService schoolService){
        this.typeService = typeService;
        this.schoolService = schoolService;
    }

    @Autowired
    private TypeService typeService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/api/type/{id}", method = RequestMethod.GET)
    public Type getType(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Type typeById = getTypeById(id);
        return typeById;
    }


    @RequestMapping(value = "/api/type")
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    public Type getTypeById(Integer id) {
        return typeService.getTypeById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/type")
    public Integer addType(@RequestBody Type type) {
        typeService.addType(type);
        return type.getId();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/type/{id}")
    public void updateType(@RequestBody Type type, @PathVariable Integer id) {
        typeService.updateType(id, type);
    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/api/type/{id}")
//    public void deleteType(@PathVariable Integer id) {
//        typeService.deleteType(id);
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/type/{schoolId}/{instrumentName}")
    public void everything(@PathVariable Integer schoolId, @PathVariable String instrumentName) {
        Type type = new Type(schoolId, instrumentName);
        typeService.addType(type);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/type/{schoolId}")
    public void deleteEverythingById(@PathVariable Integer schoolId) {
        deleteSchool(schoolId);
    }

    public void deleteSchool(Integer schoolId) {
        List<Type> everything = getAllTypes();
        List<Integer> deleteArray = new ArrayList<>();
        for(int i = 0; i < everything.size(); i++) {
            if(everything.get(i).getSchoolId() == schoolId) {
                deleteArray.add(everything.get(i).getId());
            }
        }
        for(int j = 0; j < deleteArray.size(); j++) {
            System.out.println(deleteArray.get(j));
            typeService.deleteType(deleteArray.get(j));
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/type/get/{schoolId}/{instrument}")
    public boolean check(@PathVariable Integer schoolId, @PathVariable String instrument) {
        List<Type> everything = getAllTypes();
        for(int i = 0; i < everything.size(); i++) {
            if(everything.get(i).getSchoolId() == schoolId && everything.get(i).getInstrument().equals(instrument)){
                return true;
            }
        }
        return false;
    }
}
