package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Genre;

public class GenreService {
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Genre> getGenres() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;
		List<Genre> genres = null;
		try {
			conn = connUtil.getConnection();
			GenreDAO gDao = new GenreDAO(conn);

			genres = gDao.readAllGenres();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return genres;
	}

	public void addGenre(String genreName) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Connection conn = null;
		Genre genre = new Genre();
		genre.setGenreName(genreName);
		try {
			conn = connUtil.getConnection();
			GenreDAO gDao = new GenreDAO(conn);

			gDao.createGenre(genre);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();
			GenreDAO gDao = new GenreDAO(conn);

			gDao.updateGenre(genre);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			GenreDAO gDao = new GenreDAO(conn);

			gDao.deleteGenre(genre);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
