package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)



}
