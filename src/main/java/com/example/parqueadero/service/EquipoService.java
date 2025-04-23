package com.example.parqueadero.service;

import com.example.parqueadero.model.Equipo;
import com.example.parqueadero.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo buscar(long id_equipo) {
        if (equipoRepository.existsById(id_equipo)) {
            return equipoRepository.getById(id_equipo);
        } else {
            throw new RuntimeException("Id no asignada " + id_equipo);
        }
    }

    public Equipo guardar(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }

    public void eliminar(long id_equipo){
        if (equipoRepository.existsById(id_equipo)) {
            equipoRepository.deleteById(id_equipo);
        } else {
            throw new RuntimeException("Id no asignada " + id_equipo);
        }
    }

    public Equipo actualizar(long id_equipo, Equipo equipo) {
        if (equipoRepository.existsById(id_equipo)) {
            equipo.setId_equipo(id_equipo);
            return equipoRepository.save(equipo);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
