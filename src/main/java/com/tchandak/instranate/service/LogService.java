package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Log;
import com.tchandak.instranate.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public LogService(LogRepository logRepository){
        this.logRepository = logRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Log> getAllLogs() {
        List<Log> logs = new ArrayList<>();
        logRepository.findAll()
                .forEach(logs::add);
        return logs;
    }

    public Log getLogById(Integer id) {

        //return logs.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return logRepository.findOne(id);
    }

    public void addLog(Log log) {
        logRepository.save(log);
    }

    public void updateLog(Integer id, Log log) {
        logRepository.save(log);
    }

    public void deleteLog(Integer id) {
        logRepository.delete(id);
    }
}
