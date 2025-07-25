package com.university.finance.repository;

import com.university.finance.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByStudentIdAndPaidIsFalse(Long studentId);
}