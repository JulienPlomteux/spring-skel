package com.sekl.demo.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder(toBuilder = true)
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class DefaultEntity {
  @Id @GeneratedValue private Long id;

  @CreatedDate @Column(name = "created_date") private Date createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private Date lastModifiedDate;

  public String asJsonString() {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(this);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
