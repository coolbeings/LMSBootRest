package com.gcit.lms.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopy implements Serializable{
	
	@EmbeddedId
	private BookCopyId bookCopyId;
	
	private Integer noOfCopies;
	
	public BookCopy(){
		
	}
	
	public BookCopy(BookCopyId bookCopyId, Integer noOfCopies){
		this.bookCopyId = bookCopyId;
		this.noOfCopies = noOfCopies;
	}
	
	
	/**
	 * @return the bookCopyId
	 */
	public BookCopyId getBookCopyId() {
		return bookCopyId;
	}

	/**
	 * @param bookCopyId the bookCopyId to set
	 */
	public void setBookCopyId(BookCopyId bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	/**
	 * @return the noOfCopies
	 */
	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
}
