package com.university.finance.service;

import com.university.finance.repository.BillRepository;
import org.springframework.stereotype.Service;

@Service
class FinanceServiceImpl implements FinanceService {
    private final BillRepository billRepository;

    public FinanceServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public boolean hasOutstandingPayments(Long studentId) {
        return !billRepository.findByStudentIdAndPaidIsFalse(studentId).isEmpty();
    }
}