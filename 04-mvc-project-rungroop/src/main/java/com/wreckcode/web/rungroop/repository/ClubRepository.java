package com.wreckcode.web.rungroop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wreckcode.web.rungroop.model.Club;

/**
 * ClubRepository
 */
public interface ClubRepository extends JpaRepository<Club, Long> {
  Optional<Club> findByTitle(String url);
}
