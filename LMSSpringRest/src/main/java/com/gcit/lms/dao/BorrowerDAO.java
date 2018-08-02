package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.gcit.lms.entity.Borrower;

@Component
public class BorrowerDAO extends BaseDAO<Borrower> implements ResultSetExtractor<List<Borrower>>{

	public void createBorrower(Borrower borrower)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("INSERT INTO tbl_borrower (name, address, phone) values (?,?,?)", new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone() });
	}

	public void updateBorrower(Borrower borrower)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("update tbl_borrower set name =?, address=?, phone=? where cardNo = ?", new Object[] { borrower.getName(), borrower.getAddress(), borrower.getPhone(), borrower.getCardNo() });
	}

	public void deleteBorrower(Borrower borrower)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("delete from tbl_borrower where cardNo = ?", new Object[] { borrower.getCardNo() });
	}

	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_borrower", this);
	}

	public List<Borrower> readAllBorrowersByName(String searchString) throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_borrower where name = ?", new Object[] { searchString }, this);
	}

	public Borrower readBorrowerByPK(Integer primaryKey) throws ClassNotFoundException, SQLException {
		List<Borrower> borrowers = template.query("select * from tbl_borrower where cardNo = ?", new Object[] { primaryKey }, this);
		if (!borrowers.isEmpty()) {
			return borrowers.get(0);
		}
		return null;
	}

	@Override
	public List<Borrower>  extractData(ResultSet rs) throws SQLException {
		List<Borrower> borrowers = new ArrayList<>();
		while (rs.next()) {
			Borrower borrower = new Borrower();
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrower.setAddress(rs.getString("address"));
			borrower.setPhone(rs.getString("phone"));
			borrowers.add(borrower);
		}
		return borrowers;
	}
}
