package br.com.alura.gerenciador.servlet.entities;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private static List<Company> companies = new ArrayList<>();  
	private static int companyId = 1;
	
	static {
		Database.addInitialCompanies();
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

}
