package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Renter;
import com.tchandak.instranate.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RenterService {

    @Autowired
    private RenterRepository renterRepository;

    public RenterService(RenterRepository renterRepository){
        this.renterRepository = renterRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Renter> getAllRenters() {
        List<Renter> renters = new ArrayList<>();
        renterRepository.findAll()
                .forEach(renters::add);
        return renters;
    }

    public Renter getRenterById(Integer id) {

        //return renters.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return renterRepository.findOne(id);
    }

    public void addRenter(Renter renter) {
        renterRepository.save(renter);
    }

    public void updateRenter(Integer id, Renter renter) {
        renterRepository.save(renter);
    }

    public void deleteRenter(Integer id) {
        renterRepository.delete(id);
    }
}
