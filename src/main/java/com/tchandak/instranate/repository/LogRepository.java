package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)



}
