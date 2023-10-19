package org.serratec.projetofinal.ApiRestful.DTO;

import java.util.Date;
import java.util.List;

import org.serratec.projetofinal.ApiRestful.model.Usuario;

public class UsuarioDTO {

	private String nome;

	private String sobrenome;

	private String email;

	private Date dataNascimento;

	private List<RelacionamentoDTO> relacionamennto;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.email = usuario.getEmail();
		this.dataNascimento = usuario.getDataNascimento();
//		this.relacionamennto = new ArrayList<>();
//		for (Relacionamento relacionamento : usuario.getRelacionamento()) {
//			this.relacionamennto.add(relacionamento.getId().getUsuarioseguido());
//		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<RelacionamentoDTO> getRelacionamennto() {
		return relacionamennto;
	}

	public void setRelacionamennto(List<RelacionamentoDTO> relacionamennto) {
		this.relacionamennto = relacionamennto;
	}



}
