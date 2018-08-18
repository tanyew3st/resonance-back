package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Partner;
import com.tchandak.instranate.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PartnerController {

    public PartnerController(PartnerService partnerService){
        this.partnerService = partnerService;
    }

    @Autowired
    private PartnerService partnerService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/partner")
    public void addPartner(@RequestBody Partner partner) {
        partnerService.addPartner(partner);
        System.out.println("Just added a partner that looks like " + partner.getId() + " " + partner.getUsername());

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/partner/usernames")
    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        List<Partner> allPartners = partnerService.getAllPartners();

        for(int i = 0; i < allPartners.size(); i++) {
            usernames.add(allPartners.get(i).getUsername());
        }

        return usernames;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/partner/getby/{username}")
    public Integer getByUsername(@PathVariable String username) {
        List<Partner> allPartners = partnerService.getAllPartners();

        for (int i = 0; i < allPartners.size(); i++) {
            if (allPartners.get(i).getUsername().equals(username)) {
                return allPartners.get(i).getId();
            }
        }

        return null;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/partner/{id}")
    public void updateDonor(@RequestBody Partner partner, @PathVariable Integer id) {
        partnerService.updatePartner(id, partner);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/partner/{id}", method = RequestMethod.GET)
    public Partner getPartner(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Partner partnerById = getPartnerById(id);
        return partnerById;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/partner")
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    public Partner getPartnerById(Integer id) {
        return partnerService.getPartnerById(id);
    }




}
