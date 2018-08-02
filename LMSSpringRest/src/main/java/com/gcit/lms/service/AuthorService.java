package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.entity.Author;

public class AuthorService {
	
	@Autowired
	AuthorDAO adao;
	
	public List<Author> getAuthors() throws ClassNotFoundException, SQLException{

		List<Author> authors = null;
		try {
			authors = adao.readAllAuthors();
		}   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return authors;
	}
	
	public void addAuthor(String authorName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		Author author = new Author();
		author.setAuthorName(authorName);
		try {
			adao.createAuthor(author);
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {
			adao.updateAuthor(author);
		}  catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		try {
			adao.deleteAuthor(author);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
