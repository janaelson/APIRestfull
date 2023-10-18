package org.serratec.projetofinal.ApiRestful.DTO;

import java.io.Serializable;

import org.serratec.projetofinal.ApiRestful.model.Usuario;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
