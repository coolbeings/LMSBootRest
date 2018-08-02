package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.service.BorrowerService;

public class BookLoanUIHelper {

	public void renderBookLoanOverrideOptions() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		BorrowerService service = new BorrowerService();
		List<BookLoan> loans = service.getAllBookLoans();
		
		if(loans.isEmpty()){
			System.out.println("No books are loaned");
			return;
		}
		int index = 1;
		Map<Integer, BookLoan> idToLoan = new HashMap<>();
		for(BookLoan loan: loans){
			System.out.println(index + ", " + loan.getBorrowerName() + ". " + loan.getBookName() + ", " + loan.getBranchName() + ", " + loan.getDateReturn());
			idToLoan.put(index, loan);
			index++;
		}
		
		System.out.println("Select the option to which return date needs to be updated else enter 0 to quit");
		int option = scanner.nextInt();
		if(option == 0){
			return;
		}
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the Date and time in YYYY-MM-DD hh:mm:ss, else enter quit to quit");
		String date = reader.nextLine();
		if("quit".equalsIgnoreCase(date)){
			return;
		}
		
		BookLoan loan = idToLoan.get(option);
		loan.setDateReturn(date);
		service.updateBookLoanDueDate(loan);
		System.out.println("Return date updated successfully");
	}
}
