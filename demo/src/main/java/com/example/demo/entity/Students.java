package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
public class Students {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
    generator = "student_sequence")
    @Column(
            name = "student_Id"
    )
    private Long studentId;
    @Column(
            name = "first_name"
    )
    private String firstName;
    @Column(
            name = "last_name"
    )
    private String lastName;
    @Column(
            name = "email_id",
            nullable = false
    )
    private String emailId;
    @Embedded
    private Guardian guardian;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "student_Id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName ="courseId"
            )
    )
    private List<Course> courseList;

    public void addCourse(Course course){
        if(guardian==null){
            guardian=Guardian.builder()
                    .code("")
                    .email("")
                    .mobile("")
                    .name("")
                    .build();
        }
        if(courseList==null) courseList=new ArrayList<>();
        courseList.add(course);
    }


}
