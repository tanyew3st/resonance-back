package com.tchandak.instranate.service;

import com.tchandak.instranate.domain.Image;
import com.tchandak.instranate.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }
    public void printWord() {
        System.out.println("Test Service");
    }

    public List<Image> getAllImages() {
        List<Image> images = new ArrayList<>();
        imageRepository.findAll()
                .forEach(images::add);
        return images;
    }

    public Image getImageById(Integer id) {

        //return images.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return imageRepository.findOne(id);
    }

    public void addImage(Image image) {
        imageRepository.save(image);
    }

    public void updateImage(Integer id, Image image) {
        imageRepository.save(image);
    }

    public void deleteImage(Integer id) {
        imageRepository.delete(id);
    }
}
