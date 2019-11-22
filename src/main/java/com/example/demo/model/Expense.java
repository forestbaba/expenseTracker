package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    private Long id;
    private Instant expenseDate;
    private String descript;

    @ManyToOne
    private Category category;

//    @OneToMany Thos gave me an error...Watch out for it
    @ManyToOne
    private User user;

}
