package com.gcit.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookCopy;
import com.gcit.lms.entity.BookCopyId;
import com.gcit.lms.entity.BookLoanId;

@Repository
public interface BookCopiesRepository extends JpaRepository<BookCopy, BookCopyId>{
	
}
