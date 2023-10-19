package org.serratec.projetofinal.ApiRestful.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.projetofinal.ApiRestful.DTO.UsuarioDTO;
import org.serratec.projetofinal.ApiRestful.exception.EmailException;
import org.serratec.projetofinal.ApiRestful.model.Usuario;
import org.serratec.projetofinal.ApiRestful.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
//<<<<<<< HEAD
//=======
//
//>>>>>>> branch 'main' of https://github.com/janaelson/APIRestfull.git
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		/*
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for (Usuario usuario: usuarios) {
			usuariosDTO.add(new UsuarioDTO(usuario));
		}
		*/
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return usuariosDTO;
	}
	
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
		if (usuarioOpt.isEmpty()) {
			return null;
		}
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioOpt.get());
		return usuarioDTO;
	}
	
	public UsuarioDTO inserir(Usuario usuario) throws EmailException {
		Usuario usuarioEmailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioEmailExistente != null) {
			throw new EmailException("Email já cadastrado.");
		}
//<<<<<<< HEAD
//=======
////		RelacionamentoDTO relacionamentoDTO = new RelacionamentoDTO(); 
//		Usuario usuarios = usuario;
//		usuarios.setNome(usuariosDTO.getNome());
//		usuarios.setSenha(usuariosDTO.getSobrenome());
//		usuarios.setEmail(usuariosDTO.getEmail());
//		usuarios.setDataNascimento(usuariosDTO.getDataNascimento());
////		usuario.setRelacionamento(relacionamentoDTO.getClass());
//>>>>>>> branch 'main' of https://github.com/janaelson/APIRestfull.git
		
//		usuario = usuarioRepository.save(usuario);
//		if(!usuario.getRelacionamento().isEmpty()) {
//			for(Relacionamento rela: usuario.getRelacionamento()) {
//				Optional<Usuario> findById = usuarioRepository.findById(rela.getId().getUsuarioseguido().getId());
//				rela.getId().setUsuarioseguido(findById.get());
//				rela.getId().setUsuario(usuario);
//			}
//		}
		usuario = usuarioRepository.save(usuario);
		UsuarioDTO usuarioDto = new UsuarioDTO(usuario);
		return usuarioDto;
	}

}

