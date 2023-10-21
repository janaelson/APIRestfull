package org.serratec.projetofinal.ApiRestful.model;

import java.time.LocalDate;

import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "relacionamento")
public class Relacionamento {

	@EmbeddedId
	private RelacionamentoPK id = new RelacionamentoPK();

	@Column(name = "data_inicio")
	private LocalDate dataInicio;

	public Relacionamento() {
		super();
	}

	public Relacionamento(Usuario usuario, Usuario usuarioseguido) {
		super();
		this.id.setUsuario(usuario);
		this.id.setUsuarioseguido(usuarioseguido);
		this.dataInicio = LocalDate.now();
	}

	public RelacionamentoPK getId() {
		return id;
	}

	public void setId(RelacionamentoPK id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

}
