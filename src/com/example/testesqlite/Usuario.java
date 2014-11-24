package com.example.testesqlite;

public class Usuario {
	private String nome;
	private String telefone;
	private String email;
	private long id;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, String telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
