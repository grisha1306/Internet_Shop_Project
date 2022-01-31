package com.company.service;

import com.company.repository.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributesService {

    @Autowired
    AttributesRepository repository;

}
