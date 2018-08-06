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

import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.service.BorrowerService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class BorrowerController {
	
	@Autowired
	BorrowerService borrowerServ;
	
	@RequestMapping(value = "/readBorrowers", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readBorrowers() throws SQLException {
		return borrowerServ.readBorrowers();
	}

	@RequestMapping(value = "/readBorrowerByName", method = RequestMethod.GET, produces = "application/json")
	public List<Borrower> readBorrowerByPk(@RequestParam("name") String name) {
		return borrowerServ.readBorrowerByPk(name);
	}

	@RequestMapping(value = "/readBorrowerByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Borrower> readBorrowerByPk(@RequestParam("cardNo") Integer cardNo) {
		return borrowerServ.readBorrowerByPk(cardNo);
	}
	
	@RequestMapping(value = "/addBorrower", method = RequestMethod.POST, produces = "application/json")
	public List<Borrower> addBorrower(@RequestBody Borrower borrower) {
		return borrowerServ.addBorrower(borrower);
	}
	
	@RequestMapping(value = "/deleteBorrower", method = RequestMethod.POST, produces = "application/json")
	public List<Borrower> deleteBorrower(@RequestBody Borrower borrower) {
		return borrowerServ.deleteBorrower(borrower);
	}
	
	@RequestMapping(value = "/updateBorrower", method = RequestMethod.POST, produces = "application/json")
	public List<Borrower> updateBorrower(@RequestBody Borrower borrower) {
		return borrowerServ.updateBorrower(borrower);
	}
	
}
