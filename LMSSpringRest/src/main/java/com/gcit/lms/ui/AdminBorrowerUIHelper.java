package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Borrower;
import com.gcit.lms.service.BorrowerService;

public class AdminBorrowerUIHelper {
	
	public void renderBorrowerOptions(int option) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BorrowerService borrowerService = new BorrowerService();
		if(option == 61){
			
			System.out.println("Enter Borrower Name, else 'quit' to quit to previous\n");
			String borrowerName = scanner.nextLine();
			if("quit".equalsIgnoreCase(borrowerName)){
				return;
			}
			
			System.out.println("Enter Borrower Address, else 'quit' to quit to previous\n");
			Scanner scanner1 = new Scanner(System.in);
			String borrowerAddress = scanner1.nextLine();
			if("quit".equalsIgnoreCase(borrowerAddress)){
				return;
			}
			
			System.out.println("Enter Borrower Phone, else 'quit' to quit to previous\n");
			Scanner scanner2 = new Scanner(System.in);
			String borrowerPhone = scanner2.nextLine();
			if("quit".equalsIgnoreCase(borrowerPhone)){
				return;
			}
			
			borrowerService.addBorrower(borrowerName, borrowerAddress, borrowerPhone);
			System.out.println("Borrower added successfully");
		}
		else if(option == 62){
			Map<Integer, Borrower> IdtoBorrower= displayBorrowers(true);
			System.out.println("Enter BorrowerId that you want to update, else 0 to quit to previous\n");
			int borrowerId = scanner.nextInt();
			if(borrowerId == 0){
				return;
			}
			System.out.println("Enter Borrower Name, else 'quit' to quit to previous\n");
			Scanner reader = new Scanner(System.in);
			String borrowerName = reader.nextLine();
			if("quit".equalsIgnoreCase(borrowerName)){
				return;
			}
			System.out.println("Enter Borrower Address, else 'quit' to quit to previous\n");
			Scanner addReader = new Scanner(System.in);
			String borrowerAddress = addReader.nextLine();
			if("quit".equalsIgnoreCase(borrowerAddress)){
				return;
			}System.out.println("Enter Borrower Phone, else 'quit' to quit to previous\n");
			Scanner phReader = new Scanner(System.in);
			String borrowerPhone = phReader.nextLine();
			if("quit".equalsIgnoreCase(borrowerPhone)){
				return;
			}
			
			Borrower borrower = IdtoBorrower.get(borrowerId);
			borrower.setName(borrowerName);
			borrower.setAddress(borrowerAddress);
			borrower.setPhone(borrowerPhone);
			
			borrowerService.updateBorrower(borrower);
			System.out.println("Borrower updated successfully");
		}
		else if(option == 63){
			Map<Integer, Borrower> IdtoBorrower= displayBorrowers(true);
			System.out.println("Enter BorrowerId that you want to delete, else 0 to quit to previous\n");
			int borrowerId = scanner.nextInt();
			if(borrowerId == 0){
				return;
			}

			borrowerService.deleteBorrower(IdtoBorrower.get(borrowerId));
			System.out.println("Borrower deleted successfully");
		}
		else if(option == 64){
			System.out.println("List of Borrowers\n");
			displayBorrowers(true);
		}
	}
	
	public Borrower selectBorrower() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Borrower from below List\n");
		
		Map<Integer, Borrower> idToBorrower = displayBorrowers(true);
		int borrowerId = scanner.nextInt();
		return idToBorrower.get(borrowerId);
	}
	
	public Map<Integer, Borrower> displayBorrowers(boolean renderName) throws ClassNotFoundException, SQLException{
		
		BorrowerService service = new BorrowerService();
		List<Borrower> borrowers = service.getBorrowers();
		
		int index = 1;
		Map<Integer, Borrower> idToBorrower = new HashMap<>();
		for(Borrower borrower: borrowers){
			if(renderName == true) {
				System.out.println(index + ". " + borrower.getName() + ", " + borrower.getAddress() + ", " + borrower.getPhone());
			}
			idToBorrower.put(index, borrower);
			index++;
		}
		return idToBorrower;
	}
}
