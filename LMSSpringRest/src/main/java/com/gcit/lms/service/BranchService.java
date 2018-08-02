/**
 * 
 */
package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDao;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Branch;

/**
 * @author apoorvanaik
 *
 */
public class BranchService {

	@Autowired
	Branch brDao;

	public List<Branch> getBranchDetails() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Branch> branchList = new ArrayList<>();

		try {

			branchList = brDao.readAllBranches();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return branchList;
	}

	// call DAO method to update
	public List<Branch> updateBranchDetails(Branch branch)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<Branch> branchList = new ArrayList<>();

		try {
			if (branch.getBranchId() != null) {
				brDao.updateBranch(branch);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return branchList;
	}

	public void updateBranchBookCopies(int bookId, int branchId, int noOfCopies) throws SQLException {

		try {
			brDao.updateBookCopies(bookId, branchId, noOfCopies);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addBranch(String branchName, String branchAddress)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setBranchAddress(branchAddress);

		try {

			brDao.createBranch(branch);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void deleteBranch(Branch branch)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {

			brDao.deleteBranch(branch);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateBranch(Branch branch)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {

			brDao.updateBranch(branch);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
