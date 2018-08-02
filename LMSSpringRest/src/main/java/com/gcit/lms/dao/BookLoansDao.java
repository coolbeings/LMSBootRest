package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.gcit.lms.entity.BookLoan;

@Component
public class BookLoansDao extends BaseDAO<BookLoan> implements ResultSetExtractor<List<BookLoan>>{

	public void addBookLoan(int branchId, int bookId, int cardNo, Timestamp dateOut, Timestamp dueDate) throws ClassNotFoundException, SQLException {

		template.update("INSERT INTO tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values (?,?,?,?,?)",
					new Object[] { bookId, branchId, cardNo, dateOut, dueDate });
	}
	
	public void updateReturnDate(int branchId, int bookId, int cardNo, Timestamp dateReturn) throws ClassNotFoundException, SQLException {
		template.update("update tbl_book_loans set dateIn =? where branchId = ? and bookId = ? and cardNo = ?", new Object[] {dateReturn, branchId, bookId, cardNo});
	}

	public void updateDueDate(BookLoan loan, Timestamp dueDate) throws ClassNotFoundException, SQLException {
		template.update("update tbl_book_loans set dueDate =? where branchId = ? and bookId = ? and cardNo = ?", new Object[] {dueDate, loan.getBranchId(), loan.getBookId(), loan.getCardNumber()});
	}
	
	public List<BookLoan> getLoanDetailsForBorrower(int branchId, int cardNo) throws ClassNotFoundException, SQLException{
		return template.query("select bookId, branchId, cardNo from tbl_book_loans where cardNo = ? and branchId = ? and dateIn is NULL", new Object[] {cardNo, branchId}, this);
	}

	public List<BookLoan> getAllBookLoans() throws ClassNotFoundException, SQLException {
		return template.query("select bookId, branchId, cardNo, dueDate from tbl_book_loans where dateIn is NULL" , new Object[] {}, this);
	}


	@Override
	public List<BookLoan>  extractData(ResultSet rs) throws SQLException {
		List<BookLoan> bookLoans = new ArrayList<>();
		while (rs.next()) {
			BookLoan bookLoan = new BookLoan();
			bookLoan.setCardNumber(rs.getInt("cardNo"));
			bookLoan.setBranchId(rs.getInt("branchId"));
			//Get all books written by this Borrower
			bookLoan.setBookId(rs.getInt("bookId"));
			bookLoan.setDateReturn(rs.getString("dueDate"));
//			bookLoan.setBookName(bokDao.readBookByPK(bookLoan.getBookId()).getTitle());
//			bookLoan.setBranchName(branchDao.readBranchByPK(bookLoan.getBranchId()).getBranchName());
//			bookLoan.setBorrowerName(borrowerDao.readBorrowerByPK(bookLoan.getCardNumber()).getName());
			bookLoans.add(bookLoan);
		}
		return bookLoans;
	}

}
