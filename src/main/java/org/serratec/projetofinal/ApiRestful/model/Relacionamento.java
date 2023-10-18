package org.serratec.projetofinal.ApiRestful.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "relacionamento")
public class Relacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_relationship")
	private Long id;

	@Column
	private Date dataInicioSeguimento;

	@ManyToMany
	@JoinTable(name = "seguidores_seguidos")
	@JoinColumn(name = "seguidor_id")
	@JoinColumn(name = "seguido_id")

	private List<Usuario> seguidores;

	@ManyToMany(mappedBy = "seguidores")
	private List<Usuario> seguidos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicioSeguimento() {
		return dataInicioSeguimento;
	}

	public void setDataInicioSeguimento(Date dataInicioSeguimento) {
		this.dataInicioSeguimento = dataInicioSeguimento;
	}

}
