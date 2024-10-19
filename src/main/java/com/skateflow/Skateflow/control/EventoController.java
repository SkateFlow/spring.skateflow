package com.skateflow.Skateflow.control;

import com.skateflow.Skateflow.model.Evento;
import com.skateflow.Skateflow.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> listarEventos(){
        return eventoRepository.findAll();
    }

    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento){
        return eventoRepository.save(evento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obterEvento(@PathVariable Long id){
        return eventoRepository.findById(id)
                .map(evento -> ResponseEntity.ok().body(evento))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id,@RequestBody Evento eventoDetails){
        return eventoRepository.findById(id)
                .map(evento -> {
                    evento.setNomeEvento(eventoDetails.getNomeEvento());
                    evento.setDataEvento(eventoDetails.getDataEvento());
                    evento.setLocalEvento(eventoDetails.getLocalEvento());
                    evento.setImagemEvento(eventoDetails.getImagemEvento());
                    Evento atualizado = eventoRepository.save(evento);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id){
        return eventoRepository.findById(id)
                .map(evento -> {
                    eventoRepository.delete(evento);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
