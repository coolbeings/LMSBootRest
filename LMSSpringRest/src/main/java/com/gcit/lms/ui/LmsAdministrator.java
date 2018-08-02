/**
 * 
 */
package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.BookService;
import com.gcit.lms.service.BranchService;
import com.gcit.lms.service.GenreService;
import com.gcit.lms.service.PublisherService;

import type.AdminMenuType;

/**
 * @author apoorvanaik
 *
 */
public class LmsAdministrator {
	
	public void adminMenu() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		
		while(true){
			System.out.println(
					"1. Add/Update/Delete/Read Book\n2. Add/Update/Delete/Read Author\n3. Add/Update/Delete/Read Genres\n"
							+ "4. Add/Update/Delete/Read Publishers\n5. Add/Update/Delete/Read Library Branches\n6. Add/Update/Delete/Read Borrowers\n7. Over-ride Due Date for a Book Loan");
			System.out.println("8. Quit to Previous Menu");

			Scanner reader = new Scanner(System.in);

			int optionSelected = reader.nextInt();

			if (AdminMenuType.MAIN_MENU.getOption() == optionSelected) {
				return;
			} else {
				while (true) {
					System.out.println(AdminMenuType.get(optionSelected));
					int option = reader.nextInt();

					if (option == 5) {
						break;
					}

					int selectedOption = optionSelected * 10 + option;
					
					if(selectedOption == 72){
						break;
					}

					handleAdditionalMenuOptions(selectedOption);
				}
			}
		}
	}
	
	public void handleAdditionalMenuOptions(int option) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		
		AdminAuthorUIHelper helper = new AdminAuthorUIHelper();
		
		AdminGenreHelper genreHelper = new AdminGenreHelper();
		
		AdminPublisherUIHelper publisherHelper = new AdminPublisherUIHelper();
		
		AdminBranchUIHelper branchHelper = new AdminBranchUIHelper();
		
		AdminBorrowerUIHelper borrowHelper = new AdminBorrowerUIHelper();
		
		BookLoanUIHelper bookLoanUIHelper = new BookLoanUIHelper();
		
		if(option >= 11 && option <= 14){
			renderBookOptions(option);
		}
		else if(option >= 21 && option <= 24){
			helper.renderAuthorOptions(option);
		}
		else if(option >= 31 && option <= 34){
			genreHelper.renderGenreOptions(option);
		}
		else if(option >= 41 && option <= 44){
			publisherHelper.renderPublisherOptions(option);
		}
		else if(option >= 51 && option <= 54){
			branchHelper.renderBranchOptions(option);
		}
		else if(option >= 61 && option <= 64){
			borrowHelper.renderBorrowerOptions(option);
		}
		else if(option == 71){
			bookLoanUIHelper.renderBookLoanOverrideOptions();
		}
	}

	public void renderBookOptions(int option) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		Scanner scanner = new Scanner(System.in);
		BookService service = new BookService();
		if(option == 11){
			
			System.out.println("Enter Book Title\n");
			String bookTitle = scanner.nextLine();
			AdminAuthorUIHelper helper = new AdminAuthorUIHelper();
			List<Author> selectedAuthors = helper.selectAuthor();
			
			Publisher selectedPublisher = selectPublisher();
			
			List<Genre> selectedGenre = selectGenre();
			
			List<Branch> branches = selectBranches();
			
			Book book = new Book();
			book.setAuthors(selectedAuthors);
			book.setGenres(selectedGenre);
			book.setPublisher(selectedPublisher);
			book.setTitle(bookTitle);
			
			
			service.addBook(book, branches);
			
		}
		else if(option ==12){
			
			Scanner reader = new Scanner(System.in);
			System.out.println("Select the Book to update Title\n");
			Map<Integer, Book> idToBooks = displayBooks();
			System.out.println("Select the book you want to update\n");
			int optionSelected = reader.nextInt();
			Book book = idToBooks.get(optionSelected);
			System.out.println(book.getTitle() + ": Update Title of Book\n");
			
			Scanner reader2 = new Scanner(System.in);
			String newTitle = reader2.nextLine();
			
			book.setTitle(newTitle);
			
			service.updateBook(book);
		}
		else if(option == 13){
			System.out.println("List Of Books below\n");
			Map<Integer, Book> idToBook = displayBooks();
			System.out.println("Select the book that you want to delete");
			int selectedBook = scanner.nextInt();
			Book book = idToBook.get(selectedBook);
			service.deleteBook(book);
			System.out.println(book.getTitle() + " deleted successfully\n");
		}
		else if(option == 14){
			System.out.println("List Of Books below\n");
			displayBooks();
		}
	}
	
	public Map<Integer, Book> displayBooks() throws ClassNotFoundException, SQLException{
		
		BookService service = new BookService();
		List<Book> books = service.getAllBooks();
		
		int index = 1;
		Map<Integer, Book> idToBook = new HashMap<>();
		for(Book book:books){
			System.out.println(index + ". " + book.getTitle());
			idToBook.put(index, book);
			index++;
		}
		
		return idToBook;
	}
	
	private Publisher selectPublisher() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Publisher from below List\n");
		
		PublisherService pubService = new PublisherService();
		List<Publisher> publishers = pubService.getPublishers();
		
		int pubIndex = 1;
		Map<Integer, Publisher> idToPublisher = new HashMap<>();
		for(Publisher publisher: publishers){
			System.out.println(pubIndex + ". " + publisher.getPublisherName());
			idToPublisher.put(pubIndex, publisher);
			pubIndex++;
		}
		
		int publisherId = scanner.nextInt();
		return idToPublisher.get(publisherId);
	}
	
	private List<Genre> selectGenre() throws ClassNotFoundException, SQLException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Genre from below List enter 0 to stop\n");
		
		GenreService genreService = new GenreService();
		List<Genre> genres = genreService.getGenres();
		
		int genreIndex = 1;
		Map<Integer, Genre> idToGenre = new HashMap<>();
		for(Genre genre: genres){
			System.out.println(genreIndex + ". " + genre.getGenreName());
			idToGenre.put(genreIndex, genre);
			genreIndex++;
		}
		
		List<Genre> selectedGenre = new ArrayList<>();
		while(scanner.hasNextInt()){
			int genreId = scanner.nextInt();
			if(genreId == 0) {
				break;
			}
			else {
				selectedGenre.add(idToGenre.get(genreId));
			}
		}
		
		return selectedGenre;
	}
	
	private List<Branch> selectBranches() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select branch from below");
		
		BranchService branchService = new BranchService();
		List<Branch> branches = branchService.getBranchDetails();
		
		Boolean repeat = true;
		List<Branch> branchesToUpdate = new ArrayList<>();
			
		int branchIndex = 1;
			Map<Integer, Branch> idToBranch = new HashMap<>();
			for(Branch branch: branches){
				System.out.println(branchIndex + ". " + branch.getBranchName());
				idToBranch.put(branchIndex, branch);
				branchIndex++;
			}
			while(true){
				
			System.out.println("Select branch number enter 0 to stop");
			int branchId = scanner.nextInt();
			if(branchId == 0){
				break;
			}
			
			Branch branch = idToBranch.get(branchId);
			System.out.println("Enter the number of book copies");
			int bookCopies = scanner.nextInt();
			
			
			List<Book> books = new ArrayList<>(); 
			branch.setBooks(books);
			Book book = new Book();
			book.setNoOfCopies(bookCopies);
			books.add(book);
			branchesToUpdate.add(branch);
		}
		return branchesToUpdate;
	}
}
