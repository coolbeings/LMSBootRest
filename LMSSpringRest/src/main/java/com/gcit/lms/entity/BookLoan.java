package com.gcit.lms.entity;

/**
 * @author apoorvanaik
 *
 */
public class BookLoan {

	private int cardNumber;
	
	private int branchId;
	
	private int bookId;
	
	private String bookName;
	
	private String branchName;
	
	private String borrowerName;
	
	private String dateReturn;

	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}

	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	/**
	 * @return the dateReturn
	 */
	public String getDateReturn() {
		return dateReturn;
	}

	/**
	 * @param dateReturn the dateReturn to set
	 */
	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}
}
