package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Partner;
import com.tchandak.instranate.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository){
        this.partnerRepository = partnerRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Partner> getAllPartners() {
        List<Partner> partners = new ArrayList<>();
        partnerRepository.findAll()
                .forEach(partners::add);
        return partners;
    }

    public Partner getPartnerById(Integer id) {

        //return donors.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return partnerRepository.findOne(id);
    }

    public void addPartner(Partner partner) {
        partnerRepository.save(partner);
    }

    public void updatePartner(Integer id, Partner partner) {
        partnerRepository.save(partner);
    }

    public void deletePartner(Integer id) {
        partnerRepository.delete(id);
    }




}
