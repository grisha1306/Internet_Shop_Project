package com.company.service;

import com.company.repository.ObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectsService {

    @Autowired
    ObjectsRepository repository;

}
