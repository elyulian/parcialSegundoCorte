package com.example.parqueadero.controller;


import com.example.parqueadero.model.Equipo;
import com.example.parqueadero.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/listar/{id_equipo}")
    public ResponseEntity<Equipo> buscarEquipo(@PathVariable long id_equipo) {
        try {
            Equipo equipo = equipoService.buscar(id_equipo);
            return new ResponseEntity<>(equipo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo equipo) {
        Equipo nuevo = equipoService.guardar(equipo);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Equipo>> listarEquipos() {
        List<Equipo> equipos = equipoService.listar();
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id_equipo}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable long id_equipo) {
        try {
            equipoService.eliminar(id_equipo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizar/{id_equipo}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable long id_equipo, @RequestBody Equipo equipo) {
        try {
            Equipo actualizado = equipoService.actualizar(id_equipo, equipo);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
