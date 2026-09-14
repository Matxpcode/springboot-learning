package com.wreckcode.web.rungroop.services;

import java.util.List;

import com.wreckcode.web.rungroop.dto.ClubDTO;

/**
 * ClubService
 */
public interface ClubService {
  List<ClubDTO> findAllClubs();

}
