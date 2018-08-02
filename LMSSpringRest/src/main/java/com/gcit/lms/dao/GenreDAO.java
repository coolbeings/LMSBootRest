package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;


public class GenreDAO extends BaseDAO<Genre> implements ResultSetExtractor<List<Genre>>{

	public void createGenre(Genre genre)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("INSERT INTO tbl_genre (genre_name) values (?)", new Object[] { genre.getGenreName() });
	}

	public void updateGenre(Genre genre)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("update tbl_genre set genre_name =? where genre_Id = ?", new Object[] { genre.getGenreName(), genre.getGenreId() });
	}

	public void deleteGenre(Genre genre)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("delete from tbl_genre where genre_Id = ?", new Object[] { genre.getGenreId() });
	}

	public List<Genre> readAllGenres() throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_genre", this);
	}

	public List<Genre> readAllGenresByName(String searchString) throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_genre where genre_name = ?", new Object[] { searchString }, this);
	}

	public Genre readGenreByPK(Integer primaryKey) throws ClassNotFoundException, SQLException {
		List<Genre> genres = template.query("select * from tbl_genre where genre_Id = ?", new Object[] { primaryKey }, this);
		if (!genres.isEmpty()) {
			return genres.get(0);
		}
		return null;
	}

	@Override
	public List<Genre>  extractData(ResultSet rs) throws SQLException  {
		List<Genre> genres = new ArrayList<>();
		while (rs.next()) {
			Genre genre = new Genre();
			genre.setGenreId(rs.getInt("genre_Id"));
			genre.setGenreName(rs.getString("genre_name"));
			genres.add(genre);
		}
		return genres;
	}

}
