/**
 * 
 */
package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Borrower;

/**
 * @author apoorvanaik
 *
 */
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>{
	
	@Query("from Borrower where name like %:name%")
	public List<Borrower> findByBorrowerName(@Param("name") String name);

}
