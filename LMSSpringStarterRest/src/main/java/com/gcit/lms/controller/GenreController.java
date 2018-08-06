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

import com.gcit.lms.entity.Genre;
import com.gcit.lms.service.GenreService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class GenreController {
	
	@Autowired
	GenreService genreServ;
	
	@RequestMapping(value = "/readGenres", method = RequestMethod.GET, produces = "application/json")
	public List<Genre> readGenres() throws SQLException {
		return genreServ.readGenres();
	}

	@RequestMapping(value = "/readGenreByName", method = RequestMethod.GET, produces = "application/json")
	public List<Genre> readGenreByPk(@RequestParam("genre_name") String genre_name) {
		return genreServ.readGenreByPk(genre_name);
	}

	@RequestMapping(value = "/readGenreByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Genre> readGenreByPk(@RequestParam("genre_id") Integer genre_id) {
		return genreServ.readGenreByPk(genre_id);
	}
	
	@RequestMapping(value = "/addGenre", method = RequestMethod.POST, produces = "application/json")
	public List<Genre> addGenre(@RequestBody Genre genre) {
		return genreServ.addGenre(genre);
	}
	
	@RequestMapping(value = "/deleteGenre", method = RequestMethod.POST, produces = "application/json")
	public List<Genre> deleteGenre(@RequestBody Genre genre) {
		return genreServ.deleteGenre(genre);
	}
	
	@RequestMapping(value = "/updateGenre", method = RequestMethod.POST, produces = "application/json")
	public List<Genre> updateGenre(@RequestBody Genre genre) {
		return genreServ.updateGenre(genre);
	}
}
