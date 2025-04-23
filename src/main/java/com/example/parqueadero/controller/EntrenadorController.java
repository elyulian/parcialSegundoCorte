package com.example.parqueadero.controller;


import com.example.parqueadero.model.Entrenador;
import com.example.parqueadero.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/listar/{id_entrenador}")
    public ResponseEntity<Entrenador> buscarEntrenador(@PathVariable long id_entrenador) {
        try {
            Entrenador entrenador = entrenadorService.buscar(id_entrenador);
            return new ResponseEntity<>(entrenador, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Entrenador> crearEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador nuevo = entrenadorService.guardar(entrenador);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Entrenador>> listarEntrenadores() {
        List<Entrenador> entrenadores = entrenadorService.listar();
        return new ResponseEntity<>(entrenadores, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_entrenador}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable long id_entrenador) {
        try {
            entrenadorService.eliminar(id_entrenador);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_entrenador}")
    public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable long id_entrenador, @RequestBody Entrenador entrenador) {
        try {
            Entrenador actualizado = entrenadorService.actualizar(id_entrenador, entrenador);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
