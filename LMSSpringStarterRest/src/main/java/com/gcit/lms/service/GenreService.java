package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.Genre;
import com.gcit.lms.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository genreRepo;
	
	public List<Genre> readGenres() {
		return genreRepo.findAll();
	}

	public Optional<Genre> readGenreByPk(Integer genre_id) {
		return genreRepo.findById(genre_id);
	}

	public List<Genre> readGenreByPk(String genre_name) {
		return genreRepo.findByGenreName(genre_name);
	}
	
	public List<Genre> addGenre(Genre genre){
		genreRepo.save(genre);
		return readGenres();
	}

	public List<Genre> deleteGenre(Genre genre) {
		// TODO Auto-generated method stub
		genreRepo.delete(genre);
		return readGenres();
	}

	public List<Genre> updateGenre(Genre genre) {
		// TODO Auto-generated method stub
		genreRepo.save(genre);
		return readGenres();
	}

}
