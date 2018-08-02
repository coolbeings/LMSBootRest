package com.gcit.lms.ui;

import java.util.List;

import com.gcit.lms.entity.Branch;

public class LmsUIUtil {

	public static int displayBranches(List<Branch> branches) {
		
		int numBranches = 1;
		for (Branch b : branches) {
			System.out.println(b.getBranchId() + ". " + b.getBranchName() + ", " + b.getBranchAddress());
			numBranches++;
		}
		return numBranches;
	}
}
