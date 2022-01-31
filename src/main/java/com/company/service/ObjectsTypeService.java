package com.company.service;

import com.company.repository.ObjectsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectsTypeService {

    @Autowired
    ObjectsTypeRepository repository;

}
