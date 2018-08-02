package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookLoan;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.BorrowerService;
import com.gcit.lms.service.BranchService;

public class LmsBorrower {

	public void borrowerMenu() throws ClassNotFoundException, SQLException {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the your card number:");
		int cardNumber = reader.nextInt();
		BorrowerService borrowerService = new BorrowerService();

		while (!borrowerService.validateCardNumber(cardNumber)) {
			System.out.println("Enter valid card number:");
			cardNumber = reader.nextInt();
		}

		BranchService branchService = new BranchService();

		// call to validate card no
		while (true) {
			System.out.println("1. Check out a book\n2. Return a Book\n3. Quit to Previous Menu");

			int option = reader.nextInt();

			if (option == 1) {

				System.out.println("Pick the Branch you want to check out from:");

				List<Branch> branches = branchService.getBranchDetails();

				int numBranches = LmsUIUtil.displayBranches(branches);
				System.out.println(numBranches + ". " + "Quit to previous");

				int branchSelected = reader.nextInt();

				if (branchSelected == numBranches) {
					continue;
				}

				Book book = displayBooks(branches.get(branchSelected - 1));

				if (book != null) {
					Branch branch = branches.get(branchSelected - 1);
					borrowerService.addBookLoan(branch.getBranchId(),book.getBookId(), cardNumber);
					branchService.updateBranchBookCopies(book.getBookId(), branch.getBranchId(), book.getNoOfCopies() - 1);
					System.out.println(book.getTitle() + " was successfully checked out\n");
				}

			} else if (option == 2) {
				System.out.println("Pick the Branch you want to return book:");
				// call to display the list of branches

				List<Branch> branches = branchService.getBranchDetails();

				int numBranches = LmsUIUtil.displayBranches(branches);
				System.out.println(numBranches + ". " + "Quit to previous");

				int branchSelected = reader.nextInt();

				if (branchSelected == numBranches) {
					continue;
				}
				
				Branch branch = branches.get(branchSelected - 1);
				List<BookLoan> bookLoans = borrowerService.getLoanDetailsForBorrower(branch.getBranchId(), cardNumber);
				
				if(bookLoans.isEmpty()){
					System.out.println("No books were borrowed in this branch\n");
					continue;
				}
				
				Book book = displayBooksForReturn(branch, bookLoans);

				if (book != null) {
					
					borrowerService.updateBookLoanReturnDate(branch.getBranchId(), book.getBookId(), cardNumber, null);
					branchService.updateBranchBookCopies(book.getBookId(), branch.getBranchId(), book.getNoOfCopies() + 1);
					System.out.println(book.getTitle() + " was successfully returned\n");
				}

			} else {
				break;
			}
		}
	}

	private Book displayBooks(Branch branch) throws SQLException {

		System.out.println("Pick the Book you want to check out:");

		List<Book> books = branch.getBooks();
		int index = 1;
		Map<Integer, Book> bookToId = new HashMap<>();
		if (books.size() == 0) {
			return null;
		}

		for (Book book : books) {
			if (book.getNoOfCopies() > 0) {
				System.out.println(index + ". " + book.getTitle());
				bookToId.put(index, book);
				index++;
			}
		}

		System.out.println(index + ". " + "Quit to cancel operation");

		Scanner reader = new Scanner(System.in);
		int bookOption = reader.nextInt();

		if (bookOption == index) {
			return null;
		}
		return bookToId.get(bookOption);
	}

	public Book displayBooksForReturn(Branch branch, List<BookLoan> loans) throws SQLException {
		System.out.println("Pick the Book you want to return:");

		List<Book> books = branch.getBooks();
		
		List<Book> booksLoaned = new ArrayList<>();
		
		for(BookLoan loan : loans){
			booksLoaned.addAll(books.stream().filter(book -> book.getBookId().equals(loan.getBookId())).collect(Collectors.toList()));
		}
		
		int index = 1;
		Map<Integer, Book> bookToId = new HashMap<>();

		for (Book book : booksLoaned) {
			System.out.println(index + ". " + book.getTitle());
			bookToId.put(index, book);
			index++;
		}

		System.out.println(index + ". " + "Quit to cancel operation");

		Scanner reader = new Scanner(System.in);
		int bookOption = reader.nextInt();

		if (bookOption == index) {
			return null;
		}
		return bookToId.get(bookOption);
	}
}
