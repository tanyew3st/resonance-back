package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Donor;
import com.tchandak.instranate.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorController {

    public DonorController(DonorService donorService){
        this.donorService = donorService;
    }

    @Autowired
    private DonorService donorService;

    @CrossOrigin
    @RequestMapping(value = "/api/donor/{id}", method = RequestMethod.GET)
    public Donor getDonor(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Donor donorById = getDonorById(id);
        return donorById;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/donor")
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    public Donor getDonorById(Integer id) {
        return donorService.getDonorById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/donor")
    public Integer addDonor(@RequestBody Donor donor) {
        donorService.addDonor(donor);
        return donor.getId();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/donor/{id}")
    public void updateDonor(@RequestBody Donor donor, @PathVariable Integer id) {
        donorService.updateDonor(id, donor);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/donor/{id}")
    public void deleteDonor(@PathVariable Integer id) {
        donorService.deleteDonor(id);
    }
}
