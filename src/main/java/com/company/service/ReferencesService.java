package com.company.service;

import com.company.repository.ReferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferencesService {

    @Autowired
    ReferencesRepository repository;
}
