package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="category")
public class Category {
    @Id
    private Long id;
    @NonNull
    private String name;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private User user;
}
