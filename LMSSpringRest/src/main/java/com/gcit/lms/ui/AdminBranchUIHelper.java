/**
 * 
 */
package com.gcit.lms.ui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.service.BranchService;

/**
 * @author apoorvanaik
 *
 */
public class AdminBranchUIHelper {

	public void renderBranchOptions(int option)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BranchService branchService = new BranchService();
		if (option == 51) {

			System.out.println("Enter Branch Name, else 'quit' to quit to previous\n");
			String branchName = scanner.nextLine();
			if ("quit".equalsIgnoreCase(branchName)) {
				return;
			}

			System.out.println("Enter Branch Address, else 'quit' to quit to previous\n");
			Scanner scanner1 = new Scanner(System.in);
			String branchAddress = scanner1.nextLine();
			if ("quit".equalsIgnoreCase(branchAddress)) {
				return;
			}

			branchService.addBranch(branchName, branchAddress);
			System.out.println("Branch added successfully");
		} else if (option == 52) {
			Map<Integer, Branch> IdtoBranch = displayBranchs(true);
			System.out.println("Enter BranchId that you want to update, else 0 to quit to previous\n");
			int branchId = scanner.nextInt();
			if (branchId == 0) {
				return;
			}
			System.out.println("Enter Branch Name, else 'quit' to quit to previous\n");
			Scanner reader = new Scanner(System.in);
			String branchName = reader.nextLine();
			if ("quit".equalsIgnoreCase(branchName)) {
				return;
			}
			System.out.println("Enter Branch Address, else 'quit' to quit to previous\n");
			Scanner addReader = new Scanner(System.in);
			String branchAddress = addReader.nextLine();
			if ("quit".equalsIgnoreCase(branchAddress)) {
				return;
			}

			Branch branch = IdtoBranch.get(branchId);
			branch.setBranchName(branchName);
			branch.setBranchAddress(branchAddress);

			branchService.updateBranch(branch);
			System.out.println("Branch updated successfully");
		} else if (option == 53) {
			Map<Integer, Branch> IdtoBranch = displayBranchs(true);
			System.out.println("Enter BranchId that you want to delete, else 0 to quit to previous\n");
			int branchId = scanner.nextInt();
			if (branchId == 0) {
				return;
			}

			branchService.deleteBranch(IdtoBranch.get(branchId));
			System.out.println("Branch deleted successfully");
		} else if (option == 54) {
			System.out.println("List of Branchs\n");
			displayBranchs(true);
		}
	}

	public Branch selectBranch() throws ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Select Branch from below List\n");

		Map<Integer, Branch> idToBranch = displayBranchs(true);
		int branchId = scanner.nextInt();
		return idToBranch.get(branchId);
	}

	public Map<Integer, Branch> displayBranchs(boolean renderName) throws ClassNotFoundException, SQLException {

		BranchService service = new BranchService();
		List<Branch> branchs = service.getBranchDetails();

		int index = 1;
		Map<Integer, Branch> idToBranch = new HashMap<>();
		for (Branch branch : branchs) {
			if (renderName == true) {
				System.out.println(index + ". " + branch.getBranchName() + ", " + branch.getBranchAddress());
			}
			idToBranch.put(index, branch);
			index++;
		}
		return idToBranch;
	}
}
