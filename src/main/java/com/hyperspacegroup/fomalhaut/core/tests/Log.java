package com.hyperspacegroup.fomalhaut.core.tests;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {
  @Id
  private Long id;
  private String title;
  private String body;
  private LocalDateTime dateTime;
}
