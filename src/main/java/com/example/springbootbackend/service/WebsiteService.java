package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Website;
import com.example.springbootbackend.repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService {
    @Autowired
    private WebsiteRepository websiteRepository;


    public List<Website> findAll() {
        return websiteRepository.findAll();
    }


    public Website save(Website employee) {
        return websiteRepository.save(employee);
    }


    public <T> Optional<Website> findById(Long id) {
        return websiteRepository.findById(id);
    }


    public void delete(Website employee) {
        websiteRepository.delete(employee);
    }
}
