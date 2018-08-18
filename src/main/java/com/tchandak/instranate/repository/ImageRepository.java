package com.tchandak.instranate.repository;

import com.tchandak.instranate.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
        // getAllTopics()
       //  getTopic(String id)
      //   updateTopic(Topic t)
     //    deleteTopic(String id)



}
