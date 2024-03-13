package com.example.phonemanagementajaxwebservice.controller;

import com.example.phonemanagementajaxwebservice.model.Smartphone;
import com.example.phonemanagementajaxwebservice.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> listSmart() {
        Iterable<Smartphone> smartphones = iSmartphoneService.findAll();
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmart(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findById(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmart(@RequestBody Smartphone smartphone, @PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        smartphone.setId(smartphoneOptional.get().getId());
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteById(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.OK);
    }
}
