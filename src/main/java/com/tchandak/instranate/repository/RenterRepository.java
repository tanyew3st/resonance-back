package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Donor;
import com.tchandak.instranate.domain.Renter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)


}
