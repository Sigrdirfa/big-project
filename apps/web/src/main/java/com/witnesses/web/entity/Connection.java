package com.witnesses.web.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id = UUID.randomUUID().toString();

    @Column(name = "created_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreatedDate
    @Generated(GenerationTime.INSERT)
    private Timestamp createdDate;

    @Column(name = "modified_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Timestamp modifiedDate;

    private String createdBy;

    private String modifiedBy;

    @Column(columnDefinition = "tinyint(1) default 0", nullable = false)
    @Generated(GenerationTime.INSERT)
    private Boolean isDeleted;

}
