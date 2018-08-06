package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gcit.lms.entity.Publisher;

public interface PublisherRepository  extends JpaRepository<Publisher, Integer>{
	
	@Query("from Publisher where publisherName like %:publisherName%")
	public List<Publisher> findByPublisherName(@Param("publisherName") String publisherName);

}
