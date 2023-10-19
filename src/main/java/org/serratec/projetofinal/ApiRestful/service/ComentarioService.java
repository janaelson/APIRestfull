package org.serratec.projetofinal.ApiRestful.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.projetofinal.ApiRestful.model.Comentario;
import org.serratec.projetofinal.ApiRestful.DTO.ComentarioDTO;
import org.serratec.projetofinal.ApiRestful.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<ComentarioDTO> listarComentariosPorPostagem(Long postagemId) {
        List<Comentario> comentarios = comentarioRepository.findByPostagemId(postagemId);
        return comentarios.stream()
            .map(this::comentarioParaComentarioDTO)
            .collect(Collectors.toList());
    }

    public ComentarioDTO buscarComentarioPorId(Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        return comentarioOpt.map(this::comentarioParaComentarioDTO).orElse(null);
    }

    public ComentarioDTO inserirComentario(String texto) {
        Comentario comentario = new Comentario();
        comentario.setTexto(texto);
        comentario = comentarioRepository.save(comentario);
        return comentarioParaComentarioDTO(comentario);
    }

    public ComentarioDTO atualizarComentario(Long id, String novoTexto) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        if (comentarioOpt.isPresent()) {
            Comentario comentario = comentarioOpt.get();
            comentario.setTexto(novoTexto);
            comentario = comentarioRepository.save(comentario);
            return comentarioParaComentarioDTO(comentario);
        }
        return null;
    }

    public void excluirComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    private ComentarioDTO comentarioParaComentarioDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setTexto(comentario.getTexto());

        return comentarioDTO;
    }
}
