/**
 * 
 */
package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.BranchService;

/**
 * @author apoorvanaik
 *
 */
public class LmsLibrarian {

	public void librarianMenu()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		while (true) {
			System.out.println("1 to Enter the Branch you manage");
			System.out.println("2 to Quit to Previous Menu");

			Scanner reader = new Scanner(System.in);

			int optionSelected = reader.nextInt();

			if (optionSelected == 1) {

				displayBranches();
			} else {
				break;
			}
		}
	}

	private void displayBranches()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		while (true) {
			BranchService ls = new BranchService();
			List<Branch> branchList = ls.getBranchDetails();
			
			System.out.println("List of Libraries:");
			int numBranches = LmsUIUtil.displayBranches(branchList);
			System.out.println(numBranches + ". " + "Quit to previous");
			// call to display the list of libraries
			System.out.println("Enter the branch number you manage:");
			Scanner reader = new Scanner(System.in);
			int option = reader.nextInt();
			if (option != numBranches) {
				// System.out.println("Selected Branch is " + option);
				listBranchOperations(branchList.get(option - 1));
			}
			else {
				break;
			}
		}
	}

	private void listBranchOperations(Branch branch)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		while (true) {
			System.out.println("1. Update the details of the Library\n2. Add copies of Book to the Branch\n3. Quit to previous");

			Scanner reader = new Scanner(System.in);

			int operationSelected = reader.nextInt();
			System.out.println("Selected Operation is " + operationSelected);

			if (operationSelected == 1) {
				updateLibraryDetails(branch);
			}
			else if (operationSelected == 2) {
				addBookCopiesToBranch(branch);
			}
			else {
				break;
			}
		}
	}

	private void updateLibraryDetails(Branch branch)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		BranchService ls = new BranchService();

		System.out.println("You have chosen to update the Branch with Branch Id: " + branch.getBranchId()
				+ " and Branch Name: " + branch.getBranchName() + "\nEnter ‘quit’ at any prompt to cancel operation.");

		System.out.println("Please enter new branch name or enter N/A for no change:");
		Scanner reader = new Scanner(System.in);

		String enteredBranchName = reader.next();
		if ("Quit".equalsIgnoreCase(enteredBranchName)) {
			return;
		}

		System.out.println("Please enter new branch address or enter N/A for no change:");

		Scanner scanner = new Scanner(System.in);
		String enteredBranchAddress = null;
		while (scanner.hasNextLine()) {
			enteredBranchAddress = scanner.nextLine();
			break;
		}

		if ("Quit".equalsIgnoreCase(enteredBranchAddress)) {
			return;
		}
		if (!"N/A".equalsIgnoreCase(enteredBranchName)) {
			branch.setBranchName(enteredBranchName);
		}
		if (!"N/A".equalsIgnoreCase(enteredBranchAddress)) {
			branch.setBranchAddress(enteredBranchAddress);
		}

		// call service method to call dao
		ls.updateBranchDetails(branch);
		System.out.println("Successfully Updated");
		return;
	}

	private void addBookCopiesToBranch(Branch branch)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Pick the Book you want to add copies of, to your branch:");

		displayBooks(branch);
	}

	private void displayBooks(Branch branch)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		List<Book> books = branch.getBooks();
		int index = 1;
		Map<Integer, Book> bookToId = new HashMap<>();
		if (books.size() == 0) {
			return;
		}

		for (Book book : books) {
			System.out.println(index + ". " + book.getTitle());
			bookToId.put(index, book);
			index++;
		}
		Scanner scanner = new Scanner(System.in);
		int selectedBook = scanner.nextInt();

		Book book = bookToId.get(selectedBook);

		System.out.println(
				"Existing number of copies: " + String.valueOf(book.getNoOfCopies() != 0 ? book.getNoOfCopies() : 0));
		System.out.println("Enter new number of copies:");
		int newNumOfCopies = scanner.nextInt();

		BranchService ls = new BranchService();
		ls.updateBranchBookCopies(book.getBookId(), branch.getBranchId(), newNumOfCopies);
	}
}
