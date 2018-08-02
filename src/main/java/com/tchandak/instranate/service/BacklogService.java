package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Backlog;
import com.tchandak.instranate.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BacklogService {

    @Autowired
    private BacklogRepository backlogRepository;

    public BacklogService(BacklogRepository backlogRepository){
        this.backlogRepository = backlogRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Backlog> getAllBacklogs() {
        List<Backlog> backlogs = new ArrayList<>();
        backlogRepository.findAll()
                .forEach(backlogs::add);
        return backlogs;
    }

    public Backlog getBacklogById(Integer id) {

        //return backlogs.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return backlogRepository.findOne(id);
    }

    public void addBacklog(Backlog backlog) {
        backlogRepository.save(backlog);
    }

    public void updateBacklog(Integer id, Backlog backlog) {
        backlogRepository.save(backlog);
    }

    public void deleteBacklog(Integer id) {
        backlogRepository.delete(id);
    }
}
