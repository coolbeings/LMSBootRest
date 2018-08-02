package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.entity.Publisher;

public class PublisherService {
	
public ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<Publisher> getPublishers() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;
		List<Publisher> publishers = null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);

			publishers = pDao.readAllPublishers();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		return publishers;
	}
	
	public void addPublisher(String publisherName, String publisherAddress, String publisherPhone) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Connection conn = null;
		Publisher publisher = new Publisher();
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);

			pDao.createPublisher(publisher);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);

			pDao.updatePublisher(publisher);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PublisherDAO pDao = new PublisherDAO(conn);

			pDao.deletePublisher(publisher);
			conn.commit();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
