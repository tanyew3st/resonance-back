package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)



}
