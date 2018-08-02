package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Instrument;
import com.tchandak.instranate.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public InstrumentService(InstrumentRepository instrumentRepository){
        this.instrumentRepository = instrumentRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Instrument> getAllInstruments() {
        List<Instrument> instruments = new ArrayList<>();
        instrumentRepository.findAll()
                .forEach(instruments::add);
        return instruments;
    }

    public Instrument getInstrumentById(Integer id) {

        //return instruments.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return instrumentRepository.findOne(id);
    }

    public void addInstrument(Instrument instrument) {
        instrumentRepository.save(instrument);
    }

    public void updateInstrument(Integer id, Instrument instrument) {
        System.out.println("updating the instrument");
        instrumentRepository.save(instrument);
    }

    public void updateInstrumentStatus(Integer id, Instrument instrument) {
        System.out.println("updating the status");
        instrumentRepository.save(instrument);
    }

    public void deleteInstrument(Integer id) {
        instrumentRepository.delete(id);
    }
}
