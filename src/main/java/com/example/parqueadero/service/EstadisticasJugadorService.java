package com.example.parqueadero.service;


import com.example.parqueadero.model.EstadisticasJugador;
import com.example.parqueadero.model.Jugador;
import com.example.parqueadero.repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorService {
    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public EstadisticasJugador buscar(long id_estadistica) {
        if (estadisticasJugadorRepository.existsById(id_estadistica)) {
            return estadisticasJugadorRepository.getById(id_estadistica);
        } else {
            throw new RuntimeException("Id no asignada " + id_estadistica);
        }
    }

    public EstadisticasJugador guardar(EstadisticasJugador estadistica){
        return estadisticasJugadorRepository.save(estadistica);
    }

    public List<EstadisticasJugador> listar(){
        return estadisticasJugadorRepository.findAll();
    }

    public void eliminar(long id_estadistica){
        if (estadisticasJugadorRepository.existsById(id_estadistica)) {
            estadisticasJugadorRepository.deleteById(id_estadistica);
        } else {
            throw new RuntimeException("Id no asignada " + id_estadistica);
        }
    }

    public EstadisticasJugador actualizar(long id_estadistica, EstadisticasJugador estadistica) {
        if (estadisticasJugadorRepository.existsById(id_estadistica)) {
            estadistica.setId_estadistica(id_estadistica);
            return estadisticasJugadorRepository.save(estadistica);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
    public List<Jugador> jugadoresConMasDeXGoles(int goles) {
        return estadisticasJugadorRepository.findJugadoresConMasDeXGoles(goles);
    }
}
