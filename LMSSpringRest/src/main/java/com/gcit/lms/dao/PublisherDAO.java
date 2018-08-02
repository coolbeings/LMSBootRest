package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Publisher;

@Component
public class PublisherDAO extends BaseDAO<Publisher> implements ResultSetExtractor<List<Publisher>>{

	public void createPublisher(Publisher publisher)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		save("INSERT INTO tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?,?,?)", new Object[] { publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone() });
	}

	public void updatePublisher(Publisher publisher)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		save("update tbl_publisher set publisherName =?, publisherAddress =?, publisherPhone =? where publisherId = ?", new Object[] { publisher.getPublisherName(),publisher.getPublisherAddress(), publisher.getPublisherPhone(), publisher.getPublisherId() });
	}

	public void deletePublisher(Publisher publisher)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		save("delete from tbl_publisher where publisherId = ?", new Object[] { publisher.getPublisherId() });
	}

	public List<Publisher> readAllPublishers() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher", null);
	}

	public List<Publisher> readAllPublishersByName(String searchString) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher where publisherName = ?", new Object[] { searchString });
	}

	public Publisher readPublisherByPK(Integer primaryKey) throws ClassNotFoundException, SQLException {
		List<Publisher> publishers = read("select * from tbl_publisher where publisherId = ?", new Object[] { primaryKey });
		if (!publishers.isEmpty()) {
			return publishers.get(0);
		}
		return null;
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		BookDAO bdao = new BookDAO(conn);
		List<Publisher> publishers = new ArrayList<>();
		while (rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(rs.getInt("PublisherId"));
			publisher.setPublisherName(rs.getString("PublisherName"));
			publisher.setPublisherAddress(rs.getString("publisherAddress"));
			publisher.setPublisherPhone(rs.getString("publisherPhone"));
			//Get all books written by this Publisher
			//publisher.setBooks(bdao.readFirstLevel("SELECT * FROM tbl_book WHERE pubId = ?", new Object[]{publisher.getPublisherId()}));
			publishers.add(publisher);
		}
		return publishers;
	}
	
	@Override
	public List<Publisher> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publishers = new ArrayList<>();
		while (rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(rs.getInt("publisherId"));
			publisher.setPublisherName(rs.getString("publisherName"));
			publisher.setPublisherAddress(rs.getString("publisherAddress"));
			publisher.setPublisherPhone(rs.getString("publisherPhone"));
			publishers.add(publisher);
		}
		return publishers;
	}

}
