package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Genre;
import com.gcit.lms.service.GenreService;

public class AdminGenreHelper {
	
	public void renderGenreOptions(int option) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		GenreService genreService = new GenreService();
		if(option == 31){
			
			System.out.println("Enter Genre Name, else 'quit' to quit to previous\n");
			String genreName = scanner.nextLine();
			if("quit".equalsIgnoreCase(genreName)){
				return;
			}
			genreService.addGenre(genreName);
			System.out.println("Genre added successfully");
		}
		else if(option == 32){
			Map<Integer, Genre> IdtoGenre= displayGenres(true);
			System.out.println("Enter GenreId that you want to update, else 0 to quit to previous\n");
			int genreId = scanner.nextInt();
			if(genreId == 0){
				return;
			}
			System.out.println("Enter Genre Name, else 'quit' to quit to previous\n");
			Scanner reader = new Scanner(System.in);
			String genreName = reader.nextLine();
			if("quit".equalsIgnoreCase(genreName)){
				return;
			}
			
			Genre genre = IdtoGenre.get(genreId);
			genre.setGenreName(genreName);
			
			genreService.updateGenre(genre);
			System.out.println("Genre updated successfully");
		}
		else if(option == 33){
			Map<Integer, Genre> IdtoGenre= displayGenres(true);
			System.out.println("Enter GenreId that you want to delete, else 0 to quit to previous\n");
			int genreId = scanner.nextInt();
			if(genreId == 0){
				return;
			}

			genreService.deleteGenre(IdtoGenre.get(genreId));
			System.out.println("Genre deleted successfully");
		}
		else if(option == 34){
			System.out.println("List of Genres\n");
			displayGenres(true);
		}
	}
	
	public Genre selectGenre() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Genre from below List\n");
		
		Map<Integer, Genre> idToGenre = displayGenres(true);
		int genreId = scanner.nextInt();
		return idToGenre.get(genreId);
	}
	
	public Map<Integer, Genre> displayGenres(boolean renderName) throws ClassNotFoundException, SQLException{
		
		GenreService service = new GenreService();
		List<Genre> genres = service.getGenres();
		
		int index = 1;
		Map<Integer, Genre> idToGenre = new HashMap<>();
		for(Genre genre: genres){
			if(renderName == true) {
				System.out.println(index + ". " + genre.getGenreName());
			}
			idToGenre.put(index, genre);
			index++;
		}
		return idToGenre;
	}
}
