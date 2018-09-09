package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Instrument;
import com.tchandak.instranate.domain.Log;
import com.tchandak.instranate.service.InstrumentService;
import com.tchandak.instranate.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LogController {

    public LogController(LogService logService, InstrumentService instrumentService){
        this.instrumentService = instrumentService;
        this.logService = logService;
    }

    @Autowired
    private LogService logService;

    @Autowired
    private InstrumentService instrumentService;

    private InstrumentController instrumentController;

    public Integer getIdByCrazyKey(Integer crazyKey) {
        List<Instrument> allInstruments = instrumentService.getAllInstruments();

        for(int i = 0; i < allInstruments.size(); i++) {
            if (allInstruments.get(i).getKey().intValue() == crazyKey.intValue()) {
                return allInstruments.get(i).getId();
            }
        }

        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/instrument/crazy/{crazyKey}")
    public Integer getIdByCrazy(@PathVariable Integer crazyKey) {
        return getIdByCrazyKey(crazyKey);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/log/{id}", method = RequestMethod.GET)
    public List<Log> getLog(@PathVariable(value = "id") Integer crazyKey) {
        Integer id;
        System.out.println("Hitting the endpoint at " + crazyKey);
        id = getIdByCrazyKey(crazyKey);
        List<Log> returnThis = getLogsByInstrumentId(id);

        return returnThis;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/log/donor/{id}", method = RequestMethod.GET)
    public Log getDonorLog(@PathVariable(value = "id") Integer crazyKey) {
        Integer id;
        id = getIdByCrazyKey(crazyKey);

        List<Log> allLogs = logService.getAllLogs();

        for (int i = 0; i < allLogs.size(); i++) {
            if(allLogs.get(i).getInstrumentId() == id && allLogs.get(i).getType().equals("donation")) {
                return allLogs.get(i);
            }
        }

        return null;
    }



    @CrossOrigin
    @RequestMapping(value = "/api/log")
    public List<Log> getAllLogs() {
        return logService.getAllLogs();
    }

    public List<Log> getLogsByInstrumentId(Integer id) {

        List<Log> allLogs = logService.getAllLogs();
        List<Log> returnList = new ArrayList<>();

        for (int i = 0; i < allLogs.size(); i++) {
            if(allLogs.get(i).getInstrumentId() == id && allLogs.get(i).getType().equals("rental")) {
                returnList.add(allLogs.get(i));
            }
        }

        return returnList;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/log")
    public void addLog(@RequestBody Log log) {
        logService.addLog(log);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/log/{id}")
    public void updateLog(@RequestBody Log log, @PathVariable Integer id) {
        logService.updateLog(id, log);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/log/{id}")
    public void deleteLog(@PathVariable Integer id) {
        logService.deleteLog(id);
    }
}
