/**
 * 
 */
package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Branch;

/**
 * @author apoorvanaik
 *
 */

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
	@Query("from Branch where branchName like %:branchName%")
	public List<Branch> findByBranchName(@Param("branchName") String branchName);

}
