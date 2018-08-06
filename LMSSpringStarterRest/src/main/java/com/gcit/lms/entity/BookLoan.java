package com.gcit.lms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_book_loans")
public class BookLoan implements Serializable{
	
	@EmbeddedId
	private BookLoanId bookLoanId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOut;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIn;
	
	public BookLoan(){
		
	}
	
	public BookLoan(BookLoanId bookLoanId, Date dateOut, Date dueDate, Date dateIn){
		this.bookLoanId = bookLoanId;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
		this.dateIn = dateIn;
	}
	
	/**
	 * @return the dateOut
	 */
	public Date getDateOut() {
		return dateOut;
	}

	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the dateIn
	 */
	public Date getDateIn() {
		return dateIn;
	}

	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	/**
	 * @return the bookLoanId
	 */
	public BookLoanId getBookLoanId() {
		return bookLoanId;
	}

	/**
	 * @param bookLoanId the bookLoanId to set
	 */
	public void setBookLoanId(BookLoanId bookLoanId) {
		this.bookLoanId = bookLoanId;
	}
}
