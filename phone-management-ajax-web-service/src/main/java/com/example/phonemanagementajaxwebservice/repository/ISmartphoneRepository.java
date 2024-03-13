package com.example.phonemanagementajaxwebservice.repository;

import com.example.phonemanagementajaxwebservice.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface ISmartphoneRepository extends CrudRepository<Smartphone,Long> {
}
