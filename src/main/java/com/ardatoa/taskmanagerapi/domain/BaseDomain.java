


//Kodları incele

package com.ardatoa.taskmanagerapi.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@SQLRestriction("is_deleted = false")
@SQLDelete(sql = "UPDATE {table_name} SET is_deleted = true WHERE id = ?")

public class BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;

    private boolean isDeleted;

}
