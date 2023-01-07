package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;

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
                        nullable = true
               )
        ),
        @AttributeOverride(name = "mobile",
        column = @Column(name = "guardian_mobile")
)
}
)


public class Guardian {
    private String name;
    private String email;
    private String mobile;
    private String code;
}
