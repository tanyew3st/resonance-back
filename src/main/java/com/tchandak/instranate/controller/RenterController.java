package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Renter;
import com.tchandak.instranate.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RenterController {

    public RenterController(RenterService renterService){
        this.renterService = renterService;
    }

    @Autowired
    private RenterService renterService;

    @CrossOrigin
    @RequestMapping(value = "/api/renter/partner/{id}", method = RequestMethod.GET)
    public List<Renter> getRentersByPartnerId(@PathVariable(value = "id") Integer id) {
        List<Renter> allRenters = renterService.getAllRenters();
        List<Renter> returnList = new ArrayList<>();

        for (int i = 0; i < allRenters.size(); i++) {
            if (allRenters.get(i).getPartnerId() == id) {
                returnList.add(allRenters.get(i));
            }
        }

        return returnList;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/renter/{id}", method = RequestMethod.GET)
    public Renter getRenter(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Renter renterById = getRenterById(id);
        return renterById;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/renter/message/{id}", method = RequestMethod.PUT)
    public void putMessage(@PathVariable(value = "id") Integer id, @RequestBody String message) {
        Renter renter = getRenterById(id);
        renter.setDonorMessage(message);
        renterService.updateRenter(id, renter);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/renter")
    public List<Renter> getAllRenters() {
        return renterService.getAllRenters();
    }

    public Renter getRenterById(Integer id) {
        return renterService.getRenterById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/renter")
    public Integer addRenter(@RequestBody Renter renter) {
        renterService.addRenter(renter);
        return renter.getId();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/renter/{id}")
    public void updateRenter(@RequestBody Renter renter, @PathVariable Integer id) {
        renterService.updateRenter(id, renter);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/renter/{id}")
    public void deleteRenter(@PathVariable Integer id) {
        renterService.deleteRenter(id);
    }
}
