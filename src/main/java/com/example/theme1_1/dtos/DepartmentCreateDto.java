package com.example.theme1_1.dtos;

import com.example.theme1_1.domains.Company;
import lombok.Data;

import javax.persistence.ManyToOne;

/**
 * @author Saydali Murodullayev, Sun 6:10 PM. 3/13/2022
 */
@Data
public class DepartmentCreateDto {
    private String name;

    private Integer company_id;
}
