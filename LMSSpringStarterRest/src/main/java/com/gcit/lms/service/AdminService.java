package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.repository.BookRepository;
import com.gcit.lms.repository.BorrowerRepository;
import com.gcit.lms.repository.BranchRepository;
import com.gcit.lms.repository.GenreRepository;
import com.gcit.lms.repository.PublisherRepository;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class AdminService {
//
//	@Autowired
//	AuthorRepository authorRepo;

//	@Autowired
//	BookRepository bookRepo;
//
//	@Autowired
//	GenreRepository genreRepo;
//
//	@Autowired
//	PublisherRepository publisherRepo;
//
//	@Autowired
//	BranchRepository branchRepo;
//
//	@Autowired
//	BorrowerRepository borrowerRepo;
//
//	// All book operations
////	@RequestMapping(value = "/readBooks", method = RequestMethod.GET, produces = "application/json")
////	public List<Book> readBooks() throws SQLException {
////		return bookRepo.findAll();
////	}
////
////	@RequestMapping(value = "/readBookByName", method = RequestMethod.GET, produces = "application/json")
////	public List<Book> readBookByPk(@RequestParam("title") String title) {
////		return bookRepo.findByBookName(title);
////	}
////
////	@RequestMapping(value = "/readBookByPk", method = RequestMethod.GET, produces = "application/json")
////	public Optional<Book> readBookByPk(@RequestParam("bookId") Integer bookId) {
////		return bookRepo.findById(bookId);
////	}
//
////	// All Author Operations
////	@RequestMapping(value = "/readAuthors", method = RequestMethod.GET, produces = "application/json")
////	public List<Author> readAuthors() {
////		return authorRepo.findAll();
////	}
////
////	@RequestMapping(value = "/readAuthorByPk", method = RequestMethod.GET, produces = "application/json")
////	public Optional<Author> readAuthorByPk(@RequestParam("authorId") Integer authorId) {
////		return authorRepo.findById(authorId);
////	}
////
////	@RequestMapping(value = "/readAuthorsByName", method = RequestMethod.GET, produces = "application/json")
////	public List<Author> readAuthorByPk(@RequestParam("authorName") String authorName) {
////		return authorRepo.findByAuthorName(authorName);
////	}
//
//	// All Genre Operations
//	@RequestMapping(value = "/readGenres", method = RequestMethod.GET, produces = "application/json")
//	public List<Genre> readGenres() {
//		return genreRepo.findAll();
//	}
//
//	@RequestMapping(value = "/readGenreByPk", method = RequestMethod.GET, produces = "application/json")
//	public Optional<Genre> readGenreByPk(@RequestParam("genre_id") Integer genre_id) {
//		return genreRepo.findById(genre_id);
//	}
//
//	@RequestMapping(value = "/readGenresByName", method = RequestMethod.GET, produces = "application/json")
//	public List<Genre> readGenreByPk(@RequestParam("genre_name") String genre_name) {
//		return genreRepo.findByGenreName(genre_name);
//	}
//
//	// All Branch Operations
//	@RequestMapping(value = "/readBranches", method = RequestMethod.GET, produces = "application/json")
//	public List<Branch> readBranches() {
//		return branchRepo.findAll();
//	}
//
//	@RequestMapping(value = "/readBranchByPk", method = RequestMethod.GET, produces = "application/json")
//	public Optional<Branch> readBranchByPk(@RequestParam("branchId") Integer branchId) {
//		return branchRepo.findById(branchId);
//	}
//
//	@RequestMapping(value = "/readBranchesByName", method = RequestMethod.GET, produces = "application/json")
//	public List<Branch> readBranchByPk(@RequestParam("branchName") String branchName) {
//		return branchRepo.findByBranchName(branchName);
//	}
//
//	// All Borrower Operations
//	@RequestMapping(value = "/readBorrowers", method = RequestMethod.GET, produces = "application/json")
//	public List<Borrower> readBorrowers() {
//		return borrowerRepo.findAll();
//	}
//
//	@RequestMapping(value = "/readBorrowerByPk", method = RequestMethod.GET, produces = "application/json")
//	public Optional<Borrower> readBorrowerByPk(@RequestParam("cardNo") Integer cardNo) {
//		return borrowerRepo.findById(cardNo);
//	}
//
//	@RequestMapping(value = "/readBorrowersByName", method = RequestMethod.GET, produces = "application/json")
//	public List<Borrower> readBorrowerByPk(@RequestParam("name") String name) {
//		return borrowerRepo.findByBorrowerName(name);
//	}
//
////	// All Borrower Operations
////	@RequestMapping(value = "/readPublishers", method = RequestMethod.GET, produces = "application/json")
////	public List<Publisher> readPublishers() {
////		return publisherRepo.findAll();
////	}
////
////	@RequestMapping(value = "/readPublisherByPk", method = RequestMethod.GET, produces = "application/json")
////	public Optional<Publisher> readPublisherByPk(@RequestParam("publisherId") Integer publisherId) {
////		return publisherRepo.findById(publisherId);
////	}
////
////	@RequestMapping(value = "/readPublishersByName", method = RequestMethod.GET, produces = "application/json")
////	public List<Publisher> readPublisherByPk(@RequestParam("publisherName") String publisherName) {
////		return publisherRepo.findByPublisherName(publisherName);
////	}
//
}
