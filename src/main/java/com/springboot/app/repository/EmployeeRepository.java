package com.springboot.app.repository;

import com.springboot.app.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByFirstNameAndLastName(String firstName, String lastName);
    EmployeeEntity findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}
