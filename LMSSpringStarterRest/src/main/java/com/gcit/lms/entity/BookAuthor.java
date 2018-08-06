package com.gcit.lms.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book_authors")
public class BookAuthor implements Serializable {

	@EmbeddedId
	private BookAuthorId bookAuthorId;

	public BookAuthor() {

	}

	public BookAuthor(BookAuthorId bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}

	/**
	 * @return the bookCopyId
	 */
	public BookAuthorId getBookAuthorId() {
		return bookAuthorId;
	}

	/**
	 * @param bookCopyId
	 *            the bookCopyId to set
	 */
	public void setBookAuthorId(BookAuthorId bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}

}
