package com.gcit.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_genre", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="genre_name", scope=Genre.class)
public class Genre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer genre_id;

	@Length(max=45)
	private String genre_name;
	
	/**
	 * @return the genreId
	 */
	public Integer getGenreId() {
		return genre_id;
	}
	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(Integer genre_id) {
		this.genre_id = genre_id;
	}
	
	
	/**
	 * @return the genre_name
	 */
	public String getGenre_name() {
		return genre_name;
	}
	/**
	 * @param genre_name the genre_name to set
	 */
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
//	
//	/**
//	 * @return the books
//	 */
//	public List<Book> getBooks() {
//		return books;
//	}
//	/**
//	 * @param books the books to set
//	 */
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
	
	
}
