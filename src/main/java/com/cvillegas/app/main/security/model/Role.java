package com.cvillegas.app.main.security.model;

import com.cvillegas.app.main.model.BaseEntity;
import com.cvillegas.app.main.security.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private ERole roleName;
}