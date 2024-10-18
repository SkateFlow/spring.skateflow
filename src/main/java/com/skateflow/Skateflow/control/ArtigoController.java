package com.skateflow.Skateflow.control;

import com.skateflow.Skateflow.model.Artigo;
import com.skateflow.Skateflow.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoRepository artigoRepository;

    // Listar todos os artigos
    @GetMapping
    public List<Artigo> listarArtigos() {
        return artigoRepository.findAll();
    }

    // Criar um novo artigo
    @PostMapping
    public Artigo criarArtigo(@RequestBody Artigo artigo) {
        return artigoRepository.save(artigo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Artigo> obterArtigo(@PathVariable Long id){
        return artigoRepository.findById(id)
                .map(artigo -> ResponseEntity.ok().body(artigo))
                .orElse(ResponseEntity.notFound().build());
    }

    // Exibir um artigo pelo ID
    @GetMapping("exibir/{id}")
    public Artigo exibirArtigo(@PathVariable Long id) {
        return artigoRepository.findById(id).orElseThrow(() -> new RuntimeException("Artigo não encontrado"));
    }
    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Artigo> atualizarArtigo(@PathVariable Long id,@RequestBody Artigo artigoDetails) {
        return artigoRepository.findById(id)
                .map(artigo -> {
                    artigo.setTitulo(artigoDetails.getTitulo());
                    artigo.setConteudo(artigoDetails.getConteudo());
                    Artigo _atualizado = artigoRepository.save(artigo);
                    return ResponseEntity.ok().body(_atualizado);
                }).orElse(ResponseEntity.notFound().build());

    }
    //Delete
@DeleteMapping("/{id}")
    public ResponseEntity<?> deletarArtigo(@PathVariable Long id){
    return artigoRepository.findById(id)
                .map(artigo -> {
                    artigoRepository.delete(artigo);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

       }
    }
