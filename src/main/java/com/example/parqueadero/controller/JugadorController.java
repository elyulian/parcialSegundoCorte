package com.example.parqueadero.controller;


import com.example.parqueadero.model.Jugador;
import com.example.parqueadero.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/listar/{id_jugador}")
    public ResponseEntity<Jugador> buscarJugador(@PathVariable long id_jugador) {
        try {
            Jugador jugador = jugadorService.buscar(id_jugador);
            return new ResponseEntity<>(jugador, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        Jugador nuevo = jugadorService.guardar(jugador);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Jugador>> listarJugadores() {
        List<Jugador> jugadores = jugadorService.listar();
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_jugador}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable long id_jugador) {
        try {
            jugadorService.eliminar(id_jugador);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_jugador}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable long id_jugador, @RequestBody Jugador jugador) {
        try {
            Jugador actualizado = jugadorService.actualizar(id_jugador, jugador);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/equipo/{id_equipo}")
    public ResponseEntity<List<Jugador>> obtenerJugadoresPorEquipo(@PathVariable Long id_equipo) {
        try {
            List<Jugador> jugadores = jugadorService.buscarPorEquipo(id_equipo);
            return new ResponseEntity<>(jugadores, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
