package com.example.theme1_1.domains;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Saydali Murodullayev, Sun 5:51 PM. 3/13/2022
 */

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @ManyToOne
    private Company company;

}
