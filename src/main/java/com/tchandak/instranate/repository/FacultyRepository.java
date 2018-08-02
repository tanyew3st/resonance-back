package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)


}
