/**
 * 
 */
package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcit.lms.entity.Author;
import com.gcit.lms.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepo;
	
	public List<Author> readAuthors() {
		return authorRepo.findAll();
	}

	public Optional<Author> readAuthorByPk(Integer authorId) {
		return authorRepo.findById(authorId);
	}

	public List<Author> readAuthorByPk(String authorName) {
		return authorRepo.findByAuthorName(authorName);
	}
	
	public List<Author> addAuthor(Author author){
		authorRepo.save(author);
		return readAuthors();
	}

	public List<Author> deleteAuthor(Author author) {
		// TODO Auto-generated method stub
		authorRepo.delete(author);
		return readAuthors();
	}

	public List<Author> updateAuthor(Author author) {
		// TODO Auto-generated method stub
		authorRepo.save(author);
		return readAuthors();
	}
}
