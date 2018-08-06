/**
 * 
 */
package com.gcit.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.PublisherService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class PublisherController {
	
	@Autowired
	PublisherService publisherServ;
	
	@RequestMapping(value = "/readPublishers", method = RequestMethod.GET, produces = "application/json")
	public List<Publisher> readPublishers() {
		return publisherServ.readPublishers();
	}

	@RequestMapping(value = "/readPublisherByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Publisher> readPublisherByPk(@RequestParam("publisherId") Integer publisherId) {
		return publisherServ.readPublisherByPk(publisherId);
	}

	@RequestMapping(value = "/readPublishersByName", method = RequestMethod.GET, produces = "application/json")
	public List<Publisher> readPublisherByPk(@RequestParam("publisherName") String publisherName) {
		return publisherServ.readPublisherByPk(publisherName);
	}
	
	@RequestMapping(value = "/addPublisher", method = RequestMethod.POST, produces = "application/json")
	public List<Publisher> addPublisher(@RequestBody Publisher publisher) {
		return publisherServ.addPublisher(publisher);
	}
	
	@RequestMapping(value = "/deletePublisher", method = RequestMethod.POST, produces = "application/json")
	public List<Publisher> deletePublisher(@RequestBody Publisher publisher) {
		return publisherServ.deletePublisher(publisher);
	}
	
	@RequestMapping(value = "/updatePublisher", method = RequestMethod.POST, produces = "application/json")
	public List<Publisher> updatePublisher(@RequestBody Publisher publisher) {
		return publisherServ.updatePublisher(publisher);
	}
}
