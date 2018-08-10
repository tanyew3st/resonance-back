package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Backlog;
import com.tchandak.instranate.domain.Donor;
import com.tchandak.instranate.domain.Renter;
import com.tchandak.instranate.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BacklogController {

    public BacklogController(BacklogService backlogService){
        this.backlogService = backlogService;
    }

    @Autowired
    private BacklogService backlogService;

    @CrossOrigin
    @RequestMapping(value = "/api/backlog/{id}", method = RequestMethod.GET)
    public Backlog getBacklog(@PathVariable(value = "id") Integer id) {
        System.out.println("Hitting the endpoint at " + id);
        Backlog backlogById = getBacklogById(id);
        return backlogById;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/backlog")
    public List<Backlog> getAllBacklogs() {
        return backlogService.getAllBacklogs();
    }

    public Backlog getBacklogById(Integer id) {
        return backlogService.getBacklogById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/backlog")
    public Integer addBacklog(@RequestBody Backlog backlog) {
        backlogService.addBacklog(backlog);
        return backlog.getId();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/backlog/{id}")
    public void updateBacklog(@RequestBody Backlog backlog, @PathVariable Integer id) {
        backlogService.updateBacklog(id, backlog);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/backlog/{id}")
    public void deleteBacklog(@PathVariable Integer id) {
        backlogService.deleteBacklog(id);
    }



}
