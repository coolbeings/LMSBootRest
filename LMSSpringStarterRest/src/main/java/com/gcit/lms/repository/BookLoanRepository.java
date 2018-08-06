package com.gcit.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.BookLoanId;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, BookLoanId>{

}
