package com.example.phonemanagementajaxwebservice.service;

import com.example.phonemanagementajaxwebservice.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone>findAll();
    Smartphone save(Smartphone smartphone);
    Optional<Smartphone>findById(Long id);
    void remove(Long id);
}
