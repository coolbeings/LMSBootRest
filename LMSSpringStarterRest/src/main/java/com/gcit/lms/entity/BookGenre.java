package com.gcit.lms.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_book_genres", catalog="library")
public class BookGenre implements Serializable{

	
	@EmbeddedId
	private BookGenreId bookGenreId;
	
	public BookGenre(){
		
	}
	
	public BookGenre(BookGenreId bookGenreId){
		this.bookGenreId = bookGenreId;
	}
	
	
	/**
	 * @return the bookCopyId
	 */
	public BookGenreId getBookGenreId() {
		return bookGenreId;
	}

	/**
	 * @param bookCopyId the bookCopyId to set
	 */
	public void setBookGenreId(BookGenreId bookGenreId) {
		this.bookGenreId = bookGenreId;
	}

}
