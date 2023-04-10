package com.cvillegas.app.main.security.entity;

import com.cvillegas.app.main.model.BaseEntity;
import com.cvillegas.app.main.security.enums.RolName;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;
}
