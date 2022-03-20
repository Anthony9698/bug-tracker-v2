package com.bugtrackerv2.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "projects")
    @ToString.Exclude
    private Set<User> contributors = new HashSet<>();

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
