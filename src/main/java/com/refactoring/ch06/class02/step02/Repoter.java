package com.refactoring.ch06.class02.step02;

import java.util.ArrayList;
import java.util.List;

public class Repoter {
	public List<String> reportLines(Customer customer) {
		List<String> lines = new ArrayList<>();
		// after
		lines.add(("name: " + customer.getName()));
		lines.add(("location: " + customer.getLocation()));

		// gatherCustomerData(lines, customer);
		return lines;
	}

	// before
	// private void gatherCustomerData(List<String> out, Customer customer) {
	// 	out.add(("name: " + customer.getName()));
	// 	out.add(("location: " + customer.getLocation()));
	// }

	public static void main(String[] args) {
		Repoter repoter = new Repoter();
		List<String> result = repoter.reportLines(new Customer("nemo", "seoul"));
		System.out.println(result);
	}
}
