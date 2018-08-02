package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Author;
import com.gcit.lms.service.AuthorService;

public class AdminAuthorUIHelper {
	
	public void renderAuthorOptions(int option) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		AuthorService authorService = new AuthorService();
		if(option == 21){
			
			System.out.println("Enter Author Name, else 'quit' to quit to previous\n");
			String authorName = scanner.nextLine();
			if("quit".equalsIgnoreCase(authorName)){
				return;
			}
			authorService.addAuthor(authorName);
			System.out.println("Author added successfully");
		}
		else if(option == 22){
			Map<Integer, Author> IdtoAuthor= displayAuthors(true);
			System.out.println("Enter AuthorId that you want to update, else 0 to quit to previous\n");
			int authorId = scanner.nextInt();
			if(authorId == 0){
				return;
			}
			System.out.println("Enter Author Name, else 'quit' to quit to previous\n");
			Scanner reader = new Scanner(System.in);
			String authorName = reader.nextLine();
			if("quit".equalsIgnoreCase(authorName)){
				return;
			}
			
			Author author = IdtoAuthor.get(authorId);
			author.setAuthorName(authorName);
			
			authorService.updateAuthor(author);
			System.out.println("Author updated successfully");
		}
		else if(option == 23){
			Map<Integer, Author> IdtoAuthor= displayAuthors(true);
			System.out.println("Enter AuthorId that you want to delete, else 0 to quit to previous\n");
			int authorId = scanner.nextInt();
			if(authorId == 0){
				return;
			}

			authorService.deleteAuthor(IdtoAuthor.get(authorId));
			System.out.println("Author deleted successfully");
		}
		else if(option == 24){
			System.out.println("List of Authors\n");
			displayAuthors(true);
		}
	}
	
	public List<Author> selectAuthor() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Authors from below List enter 0 to stop\n");
		
		Map<Integer, Author> idToAuthor = displayAuthors(true);
		List<Author> selectedAuthors = new ArrayList<>();
		while(scanner.hasNextInt()){
			int authId = scanner.nextInt();
			if(authId == 0) {
				break;
			}
			else {
				selectedAuthors.add(idToAuthor.get(authId));
			}
		}
		return selectedAuthors;
	}
	
	public Map<Integer, Author> displayAuthors(boolean renderName) throws ClassNotFoundException, SQLException{
		
		AuthorService service = new AuthorService();
		List<Author> authors = service.getAuthors();
		
		int index = 1;
		Map<Integer, Author> idToAuthor = new HashMap<>();
		for(Author author: authors){
			if(renderName == true) {
				System.out.println(index + ". " + author.getAuthorName());
			}
			idToAuthor.put(index, author);
			index++;
		}
		return idToAuthor;
	}
}
