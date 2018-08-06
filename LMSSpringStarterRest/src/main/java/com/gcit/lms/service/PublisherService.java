package com.gcit.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcit.lms.entity.Publisher;
import com.gcit.lms.repository.PublisherRepository;

@Service
public class PublisherService {
	

	@Autowired
	PublisherRepository publisherRepo;
	
	public List<Publisher> readPublishers() {
		return publisherRepo.findAll();
	}

	public Optional<Publisher> readPublisherByPk(Integer publisherId) {
		return publisherRepo.findById(publisherId);
	}

	public List<Publisher> readPublisherByPk(String publisherName) {
		return publisherRepo.findByPublisherName(publisherName);
	}
	
	public List<Publisher> addPublisher(Publisher publisher){
		publisherRepo.save(publisher);
		return readPublishers();
	}

	public List<Publisher> deletePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		publisherRepo.delete(publisher);
		return readPublishers();
	}

	public List<Publisher> updatePublisher(Publisher publisher) {
		// TODO Auto-generated method stub
		publisherRepo.save(publisher);
		return readPublishers();
	}


}
