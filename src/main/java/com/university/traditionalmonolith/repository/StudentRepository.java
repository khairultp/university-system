package com.university.traditionalmonolith.repository;

import com.university.traditionalmonolith.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByNim(String nim);
}
