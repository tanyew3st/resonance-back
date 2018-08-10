package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Instrument;
import com.tchandak.instranate.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class InstrumentController {



    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @Autowired
    private InstrumentService instrumentService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/instrument")
    public Integer addInstrument(@RequestBody Instrument instrument) {
        Random random = new Random();

        if (instrument.getKey() == null || instrument.getKey() == 0)
        instrument.setKey(random.nextInt(Integer.MAX_VALUE));

        instrumentService.addInstrument(instrument);
        System.out.println("Just added a instrument that looks like " + instrument.getId() + " " + instrument.getStatus());

        return instrument.getKey();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello world";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/instrument/{id}", method = RequestMethod.GET)
    public Instrument getInstrument(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Instrument instrumentById = getInstrumentById(id);
        return instrumentById;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/instrument/{id}")
    public void deleteInstrument(@PathVariable Integer id) {
        instrumentService.deleteInstrument(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/instrument/money/{id}/{money}")
    public Integer addMoneyToRental(@PathVariable Integer id, @PathVariable Integer money) {
        Instrument instrument = getInstrument(id);
        Integer amountPaid = instrument.getAmountPaid();
        amountPaid = amountPaid + money;
        instrument.setAmountPaid(amountPaid);

        instrumentService.updateInstrument(id, instrument);

        return instrument.getAmountPaid();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/instrument/money/{id}/set")
    public void setAmountPaid(@PathVariable Integer id) {
        Instrument instrument = getInstrument(id);
        instrument.setAmountPaid(0);
    }


    @CrossOrigin
    @RequestMapping(value = "/api/instrument")
    public List<Instrument> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }


    public Instrument getInstrumentById(Integer id) {
        return instrumentService.getInstrumentById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/api/school/{id}/instruments")
    public List<Instrument> getAllInstrumentsFromSchool(@PathVariable(value = "id") Integer id) {
        if (getInstrumentsBySchoolId(id) != null) {
            return getInstrumentsBySchoolId(id);
        }
        else {
            return null;
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/instrument/{id}/{status}")
    public void updateInstrumentStatus(@PathVariable Integer id, @PathVariable String status) {
        Instrument instrument = getInstrument(id);

        instrument.setStatus(status);

        instrumentService.updateInstrumentStatus(id, instrument);

        Instrument instrument2 = instrumentService.getInstrumentById(id);

        System.out.println(instrument2.getId() + " " + instrument2.getStatus());

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/instrument/{id}")
    public void updateInstrument(@RequestBody Instrument instrument, @PathVariable Integer id) {
        instrumentService.updateInstrument(id, instrument);
    }


    public List<Instrument> getInstrumentsBySchoolId(Integer schoolId) {

        List<Instrument> allInstruments = new ArrayList<Instrument>();
        allInstruments = instrumentService.getAllInstruments();

        List<Instrument> returnList = new ArrayList<Instrument>();

        for(int i = 0; i < allInstruments.size(); i++) {
            if(allInstruments.get(i).getSchoolId() == schoolId) {
                returnList.add(allInstruments.get(i));
             }
        }
        System.out.println(returnList.size());
        return returnList;
    }
}
