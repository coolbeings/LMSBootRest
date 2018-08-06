package com.gcit.lms.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.BookCopy;
import com.gcit.lms.entity.BookCopyId;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.repository.BookCopiesRepository;
import com.gcit.lms.repository.BookLoanRepository;

@Service
public class BookLoanService {

	@Autowired
	private BookLoanRepository bookLoanRepo;

	@Autowired
	private BookCopiesRepository bookCopiesRepo;

	@Transactional
	public void checkOutBook(BookLoan bookLoan) {

		bookLoan.setDateOut(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));
		bookLoan.setDueDate(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusWeeks(1)));

		bookLoanRepo.save(bookLoan);

		BookCopyId bookCopyId = new BookCopyId();
		bookCopyId.setBookId(bookLoan.getBookLoanId().getBookId());
		bookCopyId.setBranchId(bookLoan.getBookLoanId().getBranchId());

		Optional<BookCopy> bookCopies = bookCopiesRepo.findById(bookCopyId);
		BookCopy bookCopy = bookCopies.get();
		bookCopy.setNoOfCopies(bookCopy.getNoOfCopies() - 1);
		bookCopiesRepo.save(bookCopy);
	}

	public List<BookLoan> readBookLoans() {
		return bookLoanRepo.findAll();
	}

	public void overrideADueDate(BookLoan bookLoan) {
		// TODO Auto-generated method stub
		Optional<BookLoan> bookLoans = bookLoanRepo.findById(bookLoan.getBookLoanId());
		bookLoan = bookLoans.get();
		bookLoan.setDueDate(bookLoan.getDueDate());

		Instant dueDateInstant = bookLoan.getDueDate().toInstant();

		bookLoan.setDueDate(Timestamp.valueOf(LocalDateTime.ofInstant(dueDateInstant, ZoneId.of("UTC")).plusWeeks(1)));
		bookLoanRepo.save(bookLoan);

	}

	public void returnABook(BookLoan bookLoan) {
		// TODO Auto-generated method stub
		Optional<BookLoan> bookLoans = bookLoanRepo.findById(bookLoan.getBookLoanId());
		bookLoan = bookLoans.get();

		if (bookLoan.getDateIn() == null) {
			bookLoan.setDateIn(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC"))));

			bookLoanRepo.save(bookLoan);
		}
	}
}
