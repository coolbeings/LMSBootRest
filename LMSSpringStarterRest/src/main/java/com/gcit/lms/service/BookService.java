package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookEntity;
import com.gcit.lms.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> readBooks() {
		return bookRepo.findAll();
	}

	public Optional<Book> readBookByPk(Integer bookId) {
		return bookRepo.findById(bookId);
	}

	public List<Book> readBookByPk(String title) {
		return bookRepo.findByBookName(title);
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookRepo.delete(book);
	}
	
}
