package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_students",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_id"
        )
)
public class students {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
    generator = "student_sequence")
    private Long studentId;
    @Column(
            name = "name"
    )
    private String firstName;
    private String LastName;
    @Column(
            name = "email_id",
            nullable = false
    )
    private String emailId;
    @Embedded
    private Guardian guardian;


}
