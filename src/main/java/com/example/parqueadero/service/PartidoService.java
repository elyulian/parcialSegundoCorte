package com.example.parqueadero.service;


import com.example.parqueadero.model.Partido;
import com.example.parqueadero.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public Partido buscar(long id_partido) {
        if (partidoRepository.existsById(id_partido)) {
            return partidoRepository.getById(id_partido);
        } else {
            throw new RuntimeException("Id no asignada " + id_partido);
        }
    }

    public Partido guardar(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> listar(){
        return partidoRepository.findAll();
    }

    public void eliminar(long id_partido){
        if (partidoRepository.existsById(id_partido)) {
            partidoRepository.deleteById(id_partido);
        } else {
            throw new RuntimeException("Id no asignada " + id_partido);
        }
    }

    public Partido actualizar(long id_partido, Partido partido) {
        if (partidoRepository.existsById(id_partido)) {
            partido.setId_partido(id_partido);
            return partidoRepository.save(partido);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
    public Integer totalGolesComoLocal(Long id_equipo) {
        return partidoRepository.totalGolesComoLocal(id_equipo);
    }

    public Integer totalGolesComoVisitante(Long id_equipo) {
        return partidoRepository.totalGolesComoVisitante(id_equipo);
    }
    public List<Object[]> obtenerResultados() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}
