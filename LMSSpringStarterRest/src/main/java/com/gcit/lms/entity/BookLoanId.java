package com.gcit.lms.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class BookLoanId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bookId;
    private Integer branchId;
    private Integer cardNo;

    public BookLoanId() {}

    public BookLoanId(Integer bookId, Integer branchId, Integer cardNo) {
        this.bookId = bookId;
        this.branchId = branchId;
        this.cardNo = cardNo;
    }

    @Override
    public boolean equals(Object o) {

    	if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookLoanId that = (BookLoanId) o;

        if (!bookId.equals(that.bookId)) return false;
        if (!branchId.equals(that.branchId)) return false;
        return cardNo.equals(that.cardNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, branchId, cardNo);
    }

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the cardNo
	 */
	public Integer getCardNo() {
		return cardNo;
	}

	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
}
