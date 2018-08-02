package com.gcit.lms.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lms.dao.BookLoansDao;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;

public class BorrowerService {
	
	@Autowired
	BorrowerDAO bdao;
	
	@Autowired
	BookLoansDao blDao;
	
	@Autowired
	Borrower borrower;
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public boolean validateCardNumber(int cardNumber) throws ClassNotFoundException, SQLException{

		try {
			borrower = bdao.readBorrowerByPK(cardNumber);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(borrower == null){
			return false;
		}
		return true;
	}
	
	public void addBookLoan(int branchId, int bookId, int cardNo) throws SQLException{
		
		try {
			
			Timestamp dateOut = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
			Timestamp dueDate = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")).plusWeeks(1));
			blDao.addBookLoan(branchId, bookId, cardNo, dateOut, dueDate);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBookLoanReturnDate(int branchId, int bookId, int cardNo, String dateReturn) throws SQLException{

		try {
			Timestamp returnDate = null;
			if(dateReturn == null){
				returnDate = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));
			}
			blDao.updateReturnDate(branchId, bookId, cardNo, returnDate);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBookLoanDueDate(BookLoan loan) throws SQLException{

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(loan.getDateReturn(), formatter);
			Timestamp dueDate = Timestamp.valueOf(dateTime);
			blDao.updateDueDate(loan, dueDate);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<BookLoan> getLoanDetailsForBorrower(int branchId, int cardNo) throws SQLException{

		List<BookLoan> loans = null;
		try {

			loans = blDao.getLoanDetailsForBorrower(branchId, cardNo);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return loans;
	}

	public void addBorrower(String borrowerName, String borrowerAddress, String borrowerPhone) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		borrower.setName(borrowerName);
		borrower.setAddress(borrowerAddress);
		borrower.setPhone(borrowerPhone);
		try {
			bdao.createBorrower(borrower);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {


		try {
			bdao.updateBorrower(borrower);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {

			bdao.deleteBorrower(borrower);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Borrower> getBorrowers() throws ClassNotFoundException, SQLException {
		List<Borrower> borrowers = null; 
		try {

			borrowers = bdao.readAllBorrowers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return borrowers;
	}

	public List<BookLoan> getAllBookLoans() throws SQLException, ClassNotFoundException {
		
		List<BookLoan> loans = null;
		try {
			
			loans = blDao.getAllBookLoans();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loans;
	}
}
