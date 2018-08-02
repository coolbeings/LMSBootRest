package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.PublisherService;

public class AdminPublisherUIHelper {

	public void renderPublisherOptions(int option) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		PublisherService publisherService = new PublisherService();
		if(option == 41){
			
			System.out.println("Enter Publisher Name, else 'quit' to quit to previous\n");
			String publisherName = scanner.nextLine();
			if("quit".equalsIgnoreCase(publisherName)){
				return;
			}
			
			System.out.println("Enter Publisher Address, else 'quit' to quit to previous\n");
			Scanner scanner1 = new Scanner(System.in);
			String publisherAddress = scanner1.nextLine();
			if("quit".equalsIgnoreCase(publisherAddress)){
				return;
			}
			
			System.out.println("Enter Publisher Phone, else 'quit' to quit to previous\n");
			Scanner scanner2 = new Scanner(System.in);
			String publisherPhone = scanner2.nextLine();
			if("quit".equalsIgnoreCase(publisherPhone)){
				return;
			}
			
			publisherService.addPublisher(publisherName, publisherAddress, publisherPhone);
			System.out.println("Publisher added successfully");
		}
		else if(option == 42){
			Map<Integer, Publisher> IdtoPublisher= displayPublishers(true);
			System.out.println("Enter PublisherId that you want to update, else 0 to quit to previous\n");
			int publisherId = scanner.nextInt();
			if(publisherId == 0){
				return;
			}
			System.out.println("Enter Publisher Name, else 'quit' to quit to previous\n");
			Scanner reader = new Scanner(System.in);
			String publisherName = reader.nextLine();
			if("quit".equalsIgnoreCase(publisherName)){
				return;
			}
			System.out.println("Enter Publisher Address, else 'quit' to quit to previous\n");
			Scanner addReader = new Scanner(System.in);
			String publisherAddress = addReader.nextLine();
			if("quit".equalsIgnoreCase(publisherAddress)){
				return;
			}System.out.println("Enter Publisher Phone, else 'quit' to quit to previous\n");
			Scanner phReader = new Scanner(System.in);
			String publisherPhone = phReader.nextLine();
			if("quit".equalsIgnoreCase(publisherPhone)){
				return;
			}
			
			Publisher publisher = IdtoPublisher.get(publisherId);
			publisher.setPublisherName(publisherName);
			publisher.setPublisherAddress(publisherAddress);
			publisher.setPublisherPhone(publisherPhone);
			
			publisherService.updatePublisher(publisher);
			System.out.println("Publisher updated successfully");
		}
		else if(option == 43){
			Map<Integer, Publisher> IdtoPublisher= displayPublishers(true);
			System.out.println("Enter PublisherId that you want to delete, else 0 to quit to previous\n");
			int publisherId = scanner.nextInt();
			if(publisherId == 0){
				return;
			}

			publisherService.deletePublisher(IdtoPublisher.get(publisherId));
			System.out.println("Publisher deleted successfully");
		}
		else if(option == 44){
			System.out.println("List of Publishers\n");
			displayPublishers(true);
		}
	}
	
	public Publisher selectPublisher() throws ClassNotFoundException, SQLException{
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Publisher from below List\n");
		
		Map<Integer, Publisher> idToPublisher = displayPublishers(true);
		int publisherId = scanner.nextInt();
		return idToPublisher.get(publisherId);
	}
	
	public Map<Integer, Publisher> displayPublishers(boolean renderName) throws ClassNotFoundException, SQLException{
		
		PublisherService service = new PublisherService();
		List<Publisher> publishers = service.getPublishers();
		
		int index = 1;
		Map<Integer, Publisher> idToPublisher = new HashMap<>();
		for(Publisher publisher: publishers){
			if(renderName == true) {
				System.out.println(index + ". " + publisher.getPublisherName() + ", " + publisher.getPublisherAddress() + ", " + publisher.getPublisherPhone());
			}
			idToPublisher.put(index, publisher);
			index++;
		}
		return idToPublisher;
	}
}
