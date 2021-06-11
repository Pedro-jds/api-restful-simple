package br.com.springboot.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1, initialValue = 1)
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
	private Long id;
	
	private String name;
	
	private int age;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public int getIdade() {
		return age;
	}

	public void setIdade(int age) {
		this.age = age;
	}
	
	
}
