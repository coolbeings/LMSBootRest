package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query("from Book where title like %:title%")
	public List<Book> findByBookName(@Param("title") String title);

}
