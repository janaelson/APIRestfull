package org.serratec.projetofinal.ApiRestful.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.projetofinal.ApiRestful.model.Comentario;
import org.serratec.projetofinal.ApiRestful.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
	
	@Autowired
    private ComentarioRepository comentarioRepository;

	
	@GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(comentarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        if (comentarioOpt.isPresent()) {
            return ResponseEntity.ok(comentarioOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Comentario> inserir(@Valid @RequestBody Comentario comentario) {
    	comentario = comentarioRepository.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @Valid @RequestBody Comentario comentario) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        if (comentarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        comentario.setId(id);
        comentarioRepository.save(comentario);
        return ResponseEntity.ok(comentario);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        if (comentarioOpt.isPresent()) {
            comentarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
