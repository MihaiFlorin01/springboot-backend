package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {

}
