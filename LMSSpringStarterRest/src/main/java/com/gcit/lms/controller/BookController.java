/**
 * 
 */
package com.gcit.lms.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookEntity;
import com.gcit.lms.service.BookEntityService;
import com.gcit.lms.service.BookService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class BookController {
	
	@Autowired
	BookService bookServ;
	
	@Autowired
	BookEntityService bookEntityServ;
	
	@RequestMapping(value = "/readBooks", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBooks() throws SQLException {
		return bookServ.readBooks();
	}

	@RequestMapping(value = "/readBookByName", method = RequestMethod.GET, produces = "application/json")
	public List<Book> readBookByPk(@RequestParam("title") String title) {
		return bookServ.readBookByPk(title);
	}

	@RequestMapping(value = "/readBookByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Book> readBookByPk(@RequestParam("bookId") Integer bookId) {
		return bookServ.readBookByPk(bookId);
	}
//	
//	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
//	public void addBook(@RequestBody BookEntity bookEntity) {
//		bookEntityServ.addBook(bookEntity);
//	}
//	
//	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST, produces = "application/json")
//	public void deleteBook(@RequestBody Book book) {
//		bookServ.deleteBook(book);
//	}
//	
//	@RequestMapping(value = "/updateBook", method = RequestMethod.POST, produces = "application/json")
//	public void updateBook(@RequestBody BookEntity bookEntity) {
//		bookEntityServ.updateBook(bookEntity);
//	}
}
