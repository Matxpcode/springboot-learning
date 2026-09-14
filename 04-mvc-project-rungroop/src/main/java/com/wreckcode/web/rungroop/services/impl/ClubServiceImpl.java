package com.wreckcode.web.rungroop.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.wreckcode.web.rungroop.dto.ClubDTO;
import com.wreckcode.web.rungroop.model.Club;
import com.wreckcode.web.rungroop.repository.ClubRepository;
import com.wreckcode.web.rungroop.services.ClubService;

/**
 * ClubServiceImpl
 */
public class ClubServiceImpl implements ClubService {

  private ClubRepository clubRepository;

  public ClubServiceImpl(ClubRepository clubRepository) {
    this.clubRepository = clubRepository;
  }

  @Override
  public List<ClubDTO> findAllClubs() {
    // TODO Auto-generated method stub

    List<Club> clubs = clubRepository.findAll();
    return clubs.stream().map((club) -> mapToClubDTO(club)).collect(Collectors.toList());
  }

  private ClubDTO mapToClubDTO(Club club) {
    ClubDTO clubDTO = ClubDTO.builder()
        .id(club.getId())
        .title(club.getTitle())
        .photoUrl(club.getPhotoUrl())
        .content(club.getContent())
        .createdOn(club.getCreatedOn())
        .updateOn(club.getUpdateOn())
        .build();
    return clubDTO;
  }
}
