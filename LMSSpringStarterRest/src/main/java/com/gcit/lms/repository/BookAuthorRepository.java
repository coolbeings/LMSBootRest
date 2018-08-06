package com.gcit.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookAuthor;
import com.gcit.lms.entity.BookAuthorId;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, BookAuthorId>{
	
}
