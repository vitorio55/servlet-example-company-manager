package br.com.alura.gerenciador.servlet.entities;

import java.util.Date;

public class Company {

	private int id;
	private String name;
	private Date establishedDate = new Date();

	public Company(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public Company() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getEstablishedDate() {
		return establishedDate;
	}
	
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}
}
