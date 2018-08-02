package com.gcit.lms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;

public class BookService {

	@Autowired
	BookDAO bdao;

	public ConnectionUtil connUtil = new ConnectionUtil();

	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {

		List<Book> books = null;
		try {
			books = bdao.readAllBooks();
		}  catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public void deleteBook(Book book)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {
			bdao.deleteBook(book);

		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addBook(Book book, List<Branch> branches)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub

		try {
			bdao.createBook(book);
			List<Book> books = bdao.returnBook(book);
			int bookId = books.get(0).getBookId();
			book.setBookId(bookId);

			for (Author author : book.getAuthors()) {
				bdao.createBookAuthor(author, bookId);
			}

			for (Genre genre : book.getGenres()) {
				bdao.createBookGenre(bookId, genre.getGenreId());
			}

			for (Branch branch : branches) {
				bdao.createBookCopies(bookId, branch.getBranchId(), branch.getBooks().get(0).getNoOfCopies());
			}

		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book book) throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {

		try {
			bdao.updateBook(book);

		}  catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
