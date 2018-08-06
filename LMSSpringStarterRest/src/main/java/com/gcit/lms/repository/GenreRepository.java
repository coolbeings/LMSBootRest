/**
 * 
 */
package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gcit.lms.entity.Genre;

/**
 * @author apoorvanaik
 *
 */
public interface GenreRepository extends JpaRepository<Genre, Integer>{
	
	@Query("from Genre where genre_name like %:genre_name%")
	public List<Genre> findByGenreName(@Param("genre_name") String genre_name);


}
