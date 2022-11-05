package com.example.seproject2022.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category", catalog = "se_project_2022")
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private CategoryName name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();
}
