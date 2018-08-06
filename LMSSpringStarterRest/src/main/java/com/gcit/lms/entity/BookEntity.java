package com.gcit.lms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_book", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="title", scope=BookEntity.class)
public class BookEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookId;
	
	@NotNull
	@Length(max=45)
	private String title;

//	private Integer noOfCopies;
	
//	private Publisher publisher;
	
//	@ManyToMany(mappedBy=”bookEntity”, cascade = CascadeType.PERSIST)
//	private List<BookAuthor> bookAuthors = new ArrayList<BookAuthor>();
//	
//	private List<BookGenre> bookGenres;
//	
//	private List<BookCopy> bookBranches;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

//	/**
//	 * @return the noOfCopies
//	 */
//	public Integer getNoOfCopies() {
//		return noOfCopies;
//	}
//
//	/**
//	 * @param noOfCopies the noOfCopies to set
//	 */
//	public void setNoOfCopies(Integer noOfCopies) {
//		this.noOfCopies = noOfCopies;
//	}
//
//	/**
//	 * @return the publisher
//	 */
//	public Publisher getPublisher() {
//		return publisher;
//	}
//
//	/**
//	 * @param publisher the publisher to set
//	 */
//	public void setPublisher(Publisher publisher) {
//		this.publisher = publisher;
//	}

//	/**
//	 * @return the bookAuthors
//	 */
//	public List<BookAuthor> getBookAuthors() {
//		return bookAuthors;
//	}
//
//	/**
//	 * @param bookAuthors the bookAuthors to set
//	 */
//	public void setBookAuthors(List<BookAuthor> bookAuthors) {
//		this.bookAuthors = bookAuthors;
//	}
//
//	/**
//	 * @return the bookGenres
//	 */
//	public List<BookGenre> getBookGenres() {
//		return bookGenres;
//	}
//
//	/**
//	 * @param bookGenres the bookGenres to set
//	 */
//	public void setBookGenres(List<BookGenre> bookGenres) {
//		this.bookGenres = bookGenres;
//	}
//
//	/**
//	 * @return the bookBranches
//	 */
//	public List<BookCopy> getBookBranches() {
//		return bookBranches;
//	}
//
//	/**
//	 * @param bookBranches the bookBranches to set
//	 */
//	public void setBookBranches(List<BookCopy> bookBranches) {
//		this.bookBranches = bookBranches;
//	}
//
//	
	
}
