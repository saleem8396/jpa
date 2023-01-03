package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name="name",
                column=@Column(name = "guardian_name")
        ),
        @AttributeOverride(name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(name = "code",
                column = @Column(name = "guardian_code",
                nullable = false)
        ),
        @AttributeOverride(name = "mobile",
        column = @Column(name = "guardian_mobile")
)
}
)
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "code_unique",
                columnNames = "code"
        )
)
public class Guardian {
    private String name;
    private String email;
    private String mobile;
    private String code;
}
