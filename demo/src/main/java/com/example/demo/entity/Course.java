package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"title","credit"}
        )
)
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_id_seq",
            sequenceName = "course_id_seq",
            allocationSize = 1
    )
    @GeneratedValue( strategy=GenerationType.SEQUENCE,
    generator = "course_id_seq")
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",
    referencedColumnName = "teacherId")
    private Teacher teacher;


}
