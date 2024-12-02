package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private int telefone;

//getters e setters

	public void setId(long Id) {
		this.Id = Id;
	}

	public long getId() {
		return Id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getTelefone() {
		return telefone;
	}
}
