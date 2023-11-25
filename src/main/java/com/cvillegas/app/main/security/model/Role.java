package com.cvillegas.app.main.security.model;

import com.cvillegas.app.main.security.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity(name = "roles")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name",unique = true)
    private ERole roleName;
}