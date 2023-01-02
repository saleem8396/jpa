package com.example.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
                name="Name",
                column=@Column(name = "guardian_name")
        ),
        @AttributeOverride(name = "Email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(name = "Mobile",
                column = @Column(name = "guardian_mobile")
        )
}
)
public class Guardian {
    private String Name;
    private String Email;
    private String Mobile;
}
