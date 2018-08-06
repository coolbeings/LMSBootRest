package com.gcit.lms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tbl_library_branch", catalog="library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="branchName", scope=Branch.class)
public class Branch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer branchId;

	@Length(max=45)
	private String branchName;

	@Length(max=45)
	private String branchAddress;
	
	
	@ManyToMany
	@JoinTable(name = "tbl_book_loans", joinColumns = { @JoinColumn(name = "branchId") }, inverseJoinColumns = { @JoinColumn(name = "cardNo") })
	private List<Borrower> borrowers;
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
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}
	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	/**
	 * @return the books
	 */
//	public List<Book> getBooks() {
//		return books;
//	}
//	/**
//	 * @param books the books to set
//	 */
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
//	/**
//	 * @return the borrowers
//	 */
	public List<Borrower> getBorrowers() {
		return borrowers;
	}
	/**
	 * @param borrowers the borrowers to set
	 */
	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
	
	

}
