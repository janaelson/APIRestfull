package org.serratec.projetofinal.ApiRestful.DTO;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date data;
	private AuthorDTO autor;
	
	public CommentDTO() {
		}

	public CommentDTO(String texto, Date data, AuthorDTO autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AuthorDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthorDTO autor) {
		this.autor = autor;
	}


}

