package com.example.parqueadero.service;


import com.example.parqueadero.model.Jugador;
import com.example.parqueadero.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public Jugador buscar(long id_jugador) {
        if (jugadorRepository.existsById(id_jugador)) {
            return jugadorRepository.getById(id_jugador);
        } else {
            throw new RuntimeException("Id no asignada " + id_jugador);
        }
    }

    public Jugador guardar(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> listar(){
        return jugadorRepository.findAll();
    }

    public void eliminar(long id_jugador){
        if (jugadorRepository.existsById(id_jugador)) {
            jugadorRepository.deleteById(id_jugador);
        } else {
            throw new RuntimeException("Id no asignada " + id_jugador);
        }
    }

    public Jugador actualizar(long id_jugador, Jugador jugador) {
        if (jugadorRepository.existsById(id_jugador)) {
            jugador.setId_jugador(id_jugador);
            return jugadorRepository.save(jugador);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
    public List<Jugador> buscarPorEquipo(Long id_equipo) {
        return jugadorRepository.findByEquipo(id_equipo);
    }
}
