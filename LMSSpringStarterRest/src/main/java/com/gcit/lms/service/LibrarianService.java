package com.gcit.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.BookCopy;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.repository.BookCopiesRepository;
import com.gcit.lms.repository.BranchRepository;

@Service
public class LibrarianService {
	

	@Autowired
	BranchRepository branchRepo;

	@Autowired
	BookCopiesRepository bookCopyRepo;
	
	public List<Branch> readBranchs() {
		return branchRepo.findAll();
	}
	
	public List<BookCopy> readBookCopies() {
		return bookCopyRepo.findAll();
	}
	
	public List<Branch> updateBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchRepo.save(branch);
		return readBranchs();
	}

	public void modifyBranchBookCopy(BookCopy bookCopy) {
		bookCopyRepo.save(bookCopy);
	}
	

}
