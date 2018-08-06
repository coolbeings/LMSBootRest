/**
 * 
 */
package com.gcit.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Author;
import com.gcit.lms.service.AuthorService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorServ;
	
	// All Read Operations
	@RequestMapping(value = "/readAuthors", method = RequestMethod.GET, produces = "application/json")
	public List<Author> readAuthors() {
		return authorServ.readAuthors();
	}

	@RequestMapping(value = "/readAuthorByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Author> readAuthorByPk(@RequestParam("authorId") Integer authorId) {
		return authorServ.readAuthorByPk(authorId);
	}

	@RequestMapping(value = "/readAuthorsByName", method = RequestMethod.GET, produces = "application/json")
	public List<Author> readAuthorByPk(@RequestParam("authorName") String authorName) {
		return authorServ.readAuthorByPk(authorName);
	}
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST, produces = "application/json")
	public List<Author> addAuthor(@RequestBody Author author) {
		return authorServ.addAuthor(author);
	}
	
	@RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST, produces = "application/json")
	public List<Author> deleteAuthor(@RequestBody Author author) {
		return authorServ.deleteAuthor(author);
	}
	
	@RequestMapping(value = "/updateAuthor", method = RequestMethod.POST, produces = "application/json")
	public List<Author> updateAuthor(@RequestBody Author author) {
		return authorServ.updateAuthor(author);
	}
}
