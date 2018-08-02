package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.District;
import com.tchandak.instranate.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        districtRepository.findAll()
                .forEach(districts::add);
        return districts;
    }

    public District getDistrictById(Integer id) {

        //return districts.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return districtRepository.findOne(id);
    }

    public void addDistrict(District district) {
        districtRepository.save(district);
    }

    public void updateDistrict(Integer id, District district) {
        districtRepository.save(district);
    }

    public void deleteDistrict(Integer id) {
        districtRepository.delete(id);
    }
}
