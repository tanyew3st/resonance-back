package com.tchandak.instranate.controller;

import com.tchandak.instranate.domain.Instrument;
import com.tchandak.instranate.domain.Image;
import com.tchandak.instranate.service.InstrumentService;
import com.tchandak.instranate.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ImageController {

    public ImageController(ImageService imageService, InstrumentService instrumentService){
        this.instrumentService = instrumentService;
        this.imageService = imageService;
    }

    @Autowired
    private ImageService imageService;

    @Autowired
    private InstrumentService instrumentService;

    private InstrumentController instrumentController;

    @CrossOrigin
    @RequestMapping(value = "/api/image/{id}", method = RequestMethod.GET)
    public Image getImage(@PathVariable(value = "id") Integer id) {
        return this.imageService.getImageById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/image/instrument/{id}")
    public List<Image> getAllImagesByInstrumentId(@PathVariable(value = "id") Integer id) {
        List<Image> allImages = imageService.getAllImages();
        List<Image> returnList = new ArrayList<>();

        for (int i = 0; i < allImages.size(); i++) {
            if (allImages.get(i).getInstrumentId() == id) {
                returnList.add(allImages.get(i));
            }
        }

        return returnList;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/image/renter/{id}")
    public Image getAllImagesByRenterId(@PathVariable(value = "id") Integer id) {
        List<Image> allImages = imageService.getAllImages();

        for (int i = 0; i < allImages.size(); i++) {
            if (allImages.get(i).getRenterId() == id) {
                return allImages.get(i);
            }
        }

        return null;
    }





    @CrossOrigin
    @RequestMapping(value = "/api/image")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/image")
    public void addImage(@RequestBody byte[] bytes) throws IOException {
        Image image = new Image();
        image.setImage(bytes);

        imageService.addImage(image);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/image/instrument/{id}")
    public void addImageToInstrumentId(@PathVariable Integer id, @RequestBody byte[] bytes) throws IOException {
        Image image = new Image();
        image.setInstrumentId(id);
        image.setImage(bytes);

        imageService.addImage(image);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/api/image/renter/{id}")
    public void addImageToRenterId(@PathVariable Integer id, @RequestBody byte[] bytes) throws IOException {
        Image image = new Image();
        image.setRenterId(id);
        image.setImage(bytes);

        imageService.addImage(image);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/api/image/{id}")
    public void updateImage(@RequestBody Image image, @PathVariable Integer id) {
        imageService.updateImage(id, image);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/image/{id}")
    public void deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
    }
}
