package com.example.theme1_1.dtos;

import com.example.theme1_1.domains.Address;
import lombok.Data;

import javax.persistence.OneToOne;

/**
 * @author Saydali Murodullayev, Sun 6:08 PM. 3/13/2022
 */
@Data
public class CompanyCreateDto {

    private String corpName;

    private String directorName;

    private Integer address_id;
}
