package com.gcit.lms.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.repository.BorrowerRepository;

@Service
public class BorrowerService {
	

	@Autowired
	BorrowerRepository borrowerRepo;
	
	public List<Borrower> readBorrowers() {
		return borrowerRepo.findAll();
	}

	public Optional<Borrower> readBorrowerByPk(Integer cardNo) {
		return borrowerRepo.findById(cardNo);
	}

	public List<Borrower> readBorrowerByPk(String name) {
		return borrowerRepo.findByBorrowerName(name);
	}
	
	public List<Borrower> addBorrower(Borrower borrower){
		borrowerRepo.save(borrower);
		return readBorrowers();
	}

	public List<Borrower> deleteBorrower(Borrower borrower) {

		borrowerRepo.delete(borrower);
		return readBorrowers();
	}

	public List<Borrower> updateBorrower(Borrower borrower) {

		borrowerRepo.save(borrower);
		return readBorrowers();
	}
}
