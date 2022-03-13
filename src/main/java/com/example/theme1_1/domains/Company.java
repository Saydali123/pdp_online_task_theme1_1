package com.example.theme1_1.domains;

import lombok.Data;

import javax.annotation.security.DenyAll;
import javax.persistence.*;

/**
 * @author Saydali Murodullayev, Sun 5:49 PM. 3/13/2022
 */
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String corpName;

    private String directorName;
    @OneToOne
    private Address address;
}
