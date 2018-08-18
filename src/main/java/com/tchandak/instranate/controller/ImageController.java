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

    public Integer getIdByCrazyKey(Integer crazyKey) {
        List<Instrument> allInstruments = instrumentService.getAllInstruments();

        for(int i = 0; i < allInstruments.size(); i++) {
            if (allInstruments.get(i).getKey().intValue() == crazyKey.intValue()) {
                return allInstruments.get(i).getId();
            }
        }

        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/image/{id}", method = RequestMethod.GET)
    public Image getImage(@PathVariable(value = "id") Integer id) {
        Image imageById = this.imageService.getImageById(id);
        return imageById;
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
