package com.example.theme1_1.repository;

import com.example.theme1_1.domains.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Saydali Murodullayev, Sun 6:07 PM. 3/13/2022
 */
public interface WorkerRepo extends JpaRepository<Worker, Integer> {
}
