/**
 * 
 */
package com.gcit.lms.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.BookCopy;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.LibrarianService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianService librarianServ;
	

	@RequestMapping(value = "/readBranchCopies", method = RequestMethod.GET, produces = "application/json")
	public List<BookCopy> readBookCopies() throws SQLException {
		return librarianServ.readBookCopies();
	}
	
	@RequestMapping(value = "/updateLibrarianBranch", method = RequestMethod.POST, produces = "application/json")
	public List<Branch> updateBranch(@RequestBody Branch branch) {
		return librarianServ.updateBranch(branch);
	}
	
	@RequestMapping(value = "/modifyBranchBookCopy", method = RequestMethod.POST, produces = "application/json")
	public void modifyBranchBookCopy(@RequestBody BookCopy bookCopy){
		librarianServ.modifyBranchBookCopy(bookCopy);
	}
}
