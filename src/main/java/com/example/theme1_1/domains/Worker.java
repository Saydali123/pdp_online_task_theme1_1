package com.example.theme1_1.domains;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Saydali Murodullayev, Sun 5:52 PM. 3/13/2022
 */

@Data
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String phoneNumber;

    @OneToOne
    private Address address;

    @ManyToOne
    private Department department;

}
