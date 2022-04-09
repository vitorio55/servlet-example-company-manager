package com.examples.servlet.company_manager.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

	private static List<Company> companies = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static int companyId = 1;
	
	static {
		Database.addInitialCompanies();

		User u1 = new User();
		u1.setLogin("first-user");
		u1.setPassword("123");
		User u2 = new User();
		u2.setLogin("second-user");
		u2.setPassword("321");

		Database.users.add(u1);
		Database.users.add(u2);
	}

	public void addCompany(Company company) {
		company.setId(Database.companyId++);
		Database.companies.add(company);
	}

	public void editCompany(Integer id, Company newData) {
		Company c = Database.companies
			.stream()
			.filter(e -> e.getId() == id)
			.findAny()
			.orElseThrow(IllegalArgumentException::new);

		c.setEstablishedDate(newData.getEstablishedDate());
		c.setName(newData.getName());
	}

	public void removeCompanyByName(String name) {
		Database.companies.removeIf(e -> e.getName().equals(name));
	}

	public void removeCompanyById(Integer id) {
		Database.companies.removeIf(e -> e.getId() == id);
	}

	public List<Company> getCompanies() {
		return Database.companies;
	}
	
	private static void addInitialCompanies() {
		companies.add(new Company("Initial Company Zero", Database.companyId++));
		companies.add(new Company("Initial Company One", Database.companyId++));
	}

	public User authenticateUser(String login, String password) {
		Optional<User> authenticatedUser = Database.users
			.stream()
			.filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
			.findFirst();

		return authenticatedUser.orElseGet(() -> null);
	}

}
