package com.cvillegas.app.main.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString @EqualsAndHashCode(callSuper = false)
@Table(name = "projects")
public class Project extends BaseEntity{
    private String description;
    private String title;
    private String username;
    private String component;
    private String icon;
}
