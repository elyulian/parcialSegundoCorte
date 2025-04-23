package com.example.parqueadero.controller;


import com.example.parqueadero.model.Partido;
import com.example.parqueadero.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping("/listar/{id_partido}")
    public ResponseEntity<Partido> buscarPartido(@PathVariable long id_partido) {
        try {
            Partido partido = partidoService.buscar(id_partido);
            return new ResponseEntity<>(partido, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Partido> crearPartido(@RequestBody Partido partido) {
        Partido nuevo = partidoService.guardar(partido);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Partido>> listarPartidos() {
        List<Partido> partidos = partidoService.listar();
        return new ResponseEntity<>(partidos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_partido}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable long id_partido) {
        try {
            partidoService.eliminar(id_partido);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_partido}")
    public ResponseEntity<Partido> actualizarPartido(@PathVariable long id_partido, @RequestBody Partido partido) {
        try {
            Partido actualizado = partidoService.actualizar(id_partido, partido);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/goles_equipo/{id_equipo}")
    public ResponseEntity<Integer> obtenerTotalGolesPorEquipo(@PathVariable Long id_equipo) {
        int total = 0;
        Integer local = partidoService.totalGolesComoLocal(id_equipo);
        Integer visita = partidoService.totalGolesComoVisitante(id_equipo);
        if (local != null) total += local;
        if (visita != null) total += visita;
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
    @GetMapping("/resultados")
    public ResponseEntity<List<Map<String, Object>>> obtenerResultados() {
        List<Object[]> resultados = partidoService.obtenerResultados();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_partido", fila[0]);
            map.put("equipo_local", fila[1]);
            map.put("equipo_visita", fila[2]);
            map.put("goles_local", fila[3]);
            map.put("goles_visita", fila[4]);
            map.put("fecha", fila[5]);
            response.add(map);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
