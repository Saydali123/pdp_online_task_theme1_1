package com.example.theme1_1.dtos;

import lombok.Data;

/**
 * @author Saydali Murodullayev, Sun 6:10 PM. 3/13/2022
 */
@Data
public class WorkerCreateDto {

    private String name;

    private String phoneNumber;

    private Integer address_id;

    private Integer department_id;
}
