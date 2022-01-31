package com.company.service;

import com.company.repository.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametersService {

    @Autowired
    ParametersRepository repository;

}
