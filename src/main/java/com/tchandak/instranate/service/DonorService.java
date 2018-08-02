package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Donor;
import com.tchandak.instranate.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository){
        this.donorRepository = donorRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Donor> getAllDonors() {
        List<Donor> donors = new ArrayList<>();
        donorRepository.findAll()
                .forEach(donors::add);
        return donors;
    }

    public Donor getDonorById(Integer id) {

        //return donors.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return donorRepository.findOne(id);
    }

    public void addDonor(Donor donor) {
        donorRepository.save(donor);
    }

    public void updateDonor(Integer id, Donor donor) {
        donorRepository.save(donor);
    }

    public void deleteDonor(Integer id) {
        donorRepository.delete(id);
    }
}
