package com.gcit.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookEntity;
import com.gcit.lms.repository.BookEntityRepository;
import com.gcit.lms.repository.BookRepository;

@Service
public class BookEntityService {

	@Autowired
	BookEntityRepository bookEntityRepo;

	@Autowired
	BookRepository bookRepo;

	public List<Book> readBooks() {
		return bookRepo.findAll();
	}

	public void addBook(BookEntity bookEntity) {
		bookEntityRepo.save(bookEntity);
	}

	public void updateBook(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		bookEntityRepo.save(bookEntity);
	}

}
