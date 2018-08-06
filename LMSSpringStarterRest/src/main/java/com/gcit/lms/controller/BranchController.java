/**
 * 
 */
package com.gcit.lms.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.BranchService;

/**
 * @author apoorvanaik
 *
 */
@RestController
public class BranchController {
	
	@Autowired
	BranchService branchServ;
	
	@RequestMapping(value = "/readBranches", method = RequestMethod.GET, produces = "application/json")
	public List<Branch> readBranches() throws SQLException {
		return branchServ.readBranches();
	}

	@RequestMapping(value = "/readBranchByName", method = RequestMethod.GET, produces = "application/json")
	public List<Branch> readBranchByPk(@RequestParam("branchName") String branchName) {
		return branchServ.readBranchByPk(branchName);
	}

	@RequestMapping(value = "/readBranchByPk", method = RequestMethod.GET, produces = "application/json")
	public Optional<Branch> readBranchByPk(@RequestParam("branchId") Integer branchId) {
		return branchServ.readBranchByPk(branchId);
	}
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST, produces = "application/json")
	public List<Branch> addBranch(@RequestBody Branch branch) {
		return branchServ.addBranch(branch);
	}
	
	@RequestMapping(value = "/deleteBranch", method = RequestMethod.POST, produces = "application/json")
	public List<Branch> deleteBranch(@RequestBody Branch branch) {
		return branchServ.deleteBranch(branch);
	}
	
	@RequestMapping(value = "/updateBranch", method = RequestMethod.POST, produces = "application/json")
	public List<Branch> updateBranch(@RequestBody Branch branch) {
		return branchServ.updateBranch(branch);
	}
}
