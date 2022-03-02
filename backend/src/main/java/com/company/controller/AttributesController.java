package com.company.controller;

import com.company.model.Attributes;
import com.company.service.AttributesService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AttributesController {

    @Autowired
    AttributesService attributesService;

    @GetMapping("/attributes/")
    public Iterable<Attributes> getAttributes(){
        return attributesService.findAll();
    }

    @PostMapping("/attributes/")
    public int createAttributes(@RequestBody Attributes attributes){
        attributesService.createAttribute(attributes);

        return HttpStatus.SC_CREATED;
    }

}
