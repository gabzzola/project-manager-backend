package com.gabzzola.projectmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "budget", precision = 19, scale = 4, nullable = false)
    private BigDecimal budget;

    @Column(name = "deleted")
    private boolean deleted = false;
}
