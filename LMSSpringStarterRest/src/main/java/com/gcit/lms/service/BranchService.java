package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.repository.BranchRepository;

@Service
public class BranchService {
	

	@Autowired
	BranchRepository branchRepo;
	
	public List<Branch> readBranches() {
		return branchRepo.findAll();
	}

	public Optional<Branch> readBranchByPk(Integer branchId) {
		return branchRepo.findById(branchId);
	}

	public List<Branch> readBranchByPk(String branchName) {
		return branchRepo.findByBranchName(branchName);
	}
	
	public List<Branch> addBranch(Branch branch){
		branchRepo.save(branch);
		return readBranches();
	}

	public List<Branch> deleteBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchRepo.delete(branch);
		return readBranches();
	}

	public List<Branch> updateBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchRepo.save(branch);
		return readBranches();
	}


}
