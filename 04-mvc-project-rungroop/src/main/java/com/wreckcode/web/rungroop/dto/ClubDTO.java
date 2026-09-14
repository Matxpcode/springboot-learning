package com.wreckcode.web.rungroop.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * ClubDTO
 */
@Data
@Builder
public class ClubDTO {
  private Long id;
  private String title;
  private String photoUrl;
  private String content;
  private LocalDateTime createdOn;
  private LocalDateTime updateOn;

}
