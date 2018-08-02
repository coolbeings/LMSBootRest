/**
 * 
 */
package com.gcit.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.gcit.lms.entity.Branch;

/**
 * @author apoorvanaik
 *
 */
@Component
public class BranchDAO  extends BaseDAO<Branch> implements ResultSetExtractor<List<Branch>>{

	public void createBranch(Branch branch)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("INSERT INTO tbl_library_branch (branchName, branchAddress) values (?,?)", new Object[] { branch.getBranchName(), branch.getBranchAddress() });
	}

	public void updateBranch(Branch branch)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("update tbl_library_branch set branchName =?, branchAddress =? where branchId = ?", new Object[] { branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId() });
	}

	public void deleteBranch(Branch branch)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		template.update("delete from tbl_library_branch where branchId = ?", new Object[] { branch.getBranchId() });
	}

	public List<Branch> readAllBranches() throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_library_branch", this);
	}

	public List<Branch> readAllBranchesByName(String searchString) throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_library_branch where branchName = ?", new Object[] { searchString }, this);
	}

	public Branch readBranchByPK(Integer primaryKey) throws ClassNotFoundException, SQLException {
		List<Branch> branchs = template.query("select * from tbl_library_branch where branchId = ?", new Object[] { primaryKey }, this);
		if (!branchs.isEmpty()) {
			return branchs.get(0);
		}
		return null;
	}
	
	public List<Branch> readAllBooks(Branch branch) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return template.query("select b.bookId, title, noOfCopies from tbl_book_copies bc INNER JOIN tbl_book b ON b.bookId = bc.bookId where bc.branchId =?", new Object[] { branch.getBranchId() }, this);
	}

	
	@Override
	public List<Branch> extractData(ResultSet rs) throws SQLException {
		List<Branch> branches = new ArrayList<>();
		while (rs.next()) {
			Branch branch = new Branch();
			branch.setBranchId(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			branches.add(branch);
		}
		return branches;
	}
}