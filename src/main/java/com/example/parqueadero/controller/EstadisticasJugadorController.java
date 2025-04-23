package com.example.parqueadero.controller;


import com.example.parqueadero.model.EstadisticasJugador;
import com.example.parqueadero.model.Jugador;
import com.example.parqueadero.service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping("/listar/{id_estadistica}")
    public ResponseEntity<EstadisticasJugador> buscarEstadistica(@PathVariable long id_estadistica) {
        try {
            EstadisticasJugador estadistica = estadisticasJugadorService.buscar(id_estadistica);
            return new ResponseEntity<>(estadistica, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<EstadisticasJugador> crearEstadistica(@RequestBody EstadisticasJugador estadistica) {
        EstadisticasJugador nueva = estadisticasJugadorService.guardar(estadistica);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EstadisticasJugador>> listarEstadisticas() {
        List<EstadisticasJugador> lista = estadisticasJugadorService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_estadistica}")
    public ResponseEntity<Void> eliminarEstadistica(@PathVariable long id_estadistica) {
        try {
            estadisticasJugadorService.eliminar(id_estadistica);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_estadistica}")
    public ResponseEntity<EstadisticasJugador> actualizarEstadistica(@PathVariable long id_estadistica, @RequestBody EstadisticasJugador estadistica) {
        try {
            EstadisticasJugador actualizada = estadisticasJugadorService.actualizar(id_estadistica, estadistica);
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/goleadores")
    public ResponseEntity<List<Jugador>> jugadoresConMasDeXGoles(@RequestParam int goles) {
        List<Jugador> jugadores = estadisticasJugadorService.jugadoresConMasDeXGoles(goles);
        return new ResponseEntity<>(jugadores, HttpStatus.OK);
    }
}
