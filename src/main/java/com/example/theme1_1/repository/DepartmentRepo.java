package com.example.theme1_1.repository;

import com.example.theme1_1.domains.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Saydali Murodullayev, Sun 6:07 PM. 3/13/2022
 */
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
