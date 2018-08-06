package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	@Query("from Author where authorName like %:authorName%")
	public List<Author> findByAuthorName(@Param("authorName") String authorName);

}
