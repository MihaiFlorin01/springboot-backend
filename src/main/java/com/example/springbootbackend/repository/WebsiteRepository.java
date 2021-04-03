package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {
    Optional<Website> findByUrl(String url);
}
