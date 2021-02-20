package com.example.springbootbackend.controller;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Website;
import com.example.springbootbackend.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/api/v1/")
public class WebsiteController {
    @Autowired
    private WebsiteService websiteService;

    //get all websites
    @GetMapping("/websites")
    public List<Website> getAll() {
        return websiteService.findAll();
    }

    //create website rest api
    @PostMapping("/websites")
    public Website create(@RequestBody Website website){
        return websiteService.save(website);
    }

    //get website by id rest api
    @GetMapping("/websites/{id}")
    public ResponseEntity<Website> getWebsiteById(@PathVariable  Long id) throws Throwable {
        Website website = (Website) websiteService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with id: " + id));
        return ResponseEntity.ok(website);
    }

    //update website rest api
    @PutMapping("/websites/{id}")
    public ResponseEntity<Website> update(@PathVariable Long id, @RequestBody Website websiteDetails) {
        Website website = websiteService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with id: " + id));

        website.setName(websiteDetails.getName());
        website.setActive(websiteDetails.isActive());
        website.setUrl(websiteDetails.getUrl());

        Website updateWebsite = websiteService.save(website);

        return ResponseEntity.ok(updateWebsite);
    }

    //delete website rest api
    @DeleteMapping("/websites/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable  Long id) {
        Website website = websiteService.findById(id).orElseThrow(() -> new ResourceNotFoundException("website not exist with id: " + id));

        websiteService.delete(website);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
