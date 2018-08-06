package com.gcit.lms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_borrower", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="name", scope=Borrower.class)
public class Borrower {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cardNo;
	
	@Length(max=45)
	private String name;
	
	@Length(max=45)
	private String address;
	
	@Length(max=45)
	private String phone;
	
//	@ManyToMany(fetch=FetchType.EAGER, mappedBy="borrowers")
//	@JsonBackReference
//	private List<Book> books;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="borrowers")
	@JsonBackReference
	private List<Branch> branches;
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	/**
	 * @return the branches
	 */
	public List<Branch> getBranches() {
		return branches;
	}
	/**
	 * @param branches the branches to set
	 */
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	

}
