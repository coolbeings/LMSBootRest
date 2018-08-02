package type;

import java.util.HashMap;
import java.util.Map;

public enum AdminMenuType {

	BOOK(1, "Please select your opration on Books:\n1. Add a Book\n2. Update a Book deatils\n3. Delete a Book from the list\n4. List all Books\n5. Quit to previous menu"),
	AUTHOR(2, "Please select your opration on Authors:\n1. Add an Author\n2. Update a Author Deatils\n3. Delete an Author from the list\n4. List all Authors\n5. Quit to previous menu"),
	GENRE(3, "Please select your opration on Genre:\n1. Add a Genre\n2. Update a Genre Deatils\n3. Delete a Genre from the list\n4. List all Genres\n5. Quit to previous menu"),
	PUBLISHER(4, "Please select your opration on Publisher:\n1. Add a Publisher\n2. Update a Publisher Deatils\n3. Delete a Publisher from the list\n4. List all Publishers\n5. Quit to previous menu"),
	BRANCHES(5, "Please select your opration on Branches:\n1. Add a Branch\n2. Update a Branch Deatils\n3. Delete a Branch from the list\n4. List all Branches\n5. Quit to previous menu"),
	BORROWER(6, "Please select your opration on Borrower:\n1. Add a Borrower\n2. Update a Borrower Deatils\n3. Delete a Borrower from the list\n4. List all Borrowers\n5. Quit to previous menu"),
	DUE_DATE(7, "1. Over ride a due date for a book loan\n2. Quit to previous menu"),
	MAIN_MENU(8, "Return to Main Menu");
	
	private int option;
	private String  statement;
	
	private static final Map<Integer,String> lookUp = new HashMap<>();
	
	 static {
	        for (AdminMenuType adminType : AdminMenuType.values()) {
	        	lookUp.put(adminType.option, adminType.statement);
	        }
	    }
	
	AdminMenuType(int option, String statement) {
		
		this.option = option;
		this.statement = statement;
	}
	
	public static String get(int optionSelected) {
		 return lookUp.get(optionSelected);
	}
	
	public int getOption(){
		return option;
	}
}
