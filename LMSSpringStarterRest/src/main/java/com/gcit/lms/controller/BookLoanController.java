package com.gcit.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.service.BookLoanService;

@RestController
public class BookLoanController {
	
	@Autowired
	private BookLoanService bookLoanServ;
	
	@RequestMapping(value = "/readBookLoan", method = RequestMethod.GET, produces = "application/json")
	public List<BookLoan> readBookLoan(){
		return bookLoanServ.readBookLoans();
	}
	
	@RequestMapping(value = "/checkOutABook", method = RequestMethod.POST, produces = "application/json")
	public void checkOutBook(@RequestBody BookLoan bookLoan){
		bookLoanServ.checkOutBook(bookLoan);
	}
	
	@RequestMapping(value = "/overrideADueDate", method = RequestMethod.POST, produces = "application/json")
	public void overrideADueDate(@RequestBody BookLoan bookLoan){
		bookLoanServ.overrideADueDate(bookLoan);
	}
	
	@RequestMapping(value = "/returnABook", method = RequestMethod.POST, produces = "application/json")
	public void returnABook(@RequestBody BookLoan bookLoan){
		bookLoanServ.returnABook(bookLoan);
	}
}
