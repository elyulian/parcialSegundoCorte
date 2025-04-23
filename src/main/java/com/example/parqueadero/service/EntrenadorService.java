package com.example.parqueadero.service;

import com.example.parqueadero.model.Entrenador;
import com.example.parqueadero.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador buscar(long id_entrenador) {
        if (entrenadorRepository.existsById(id_entrenador)) {
            return entrenadorRepository.getById(id_entrenador);
        } else {
            throw new RuntimeException("Id no asignada " + id_entrenador);
        }
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    public void eliminar(long id_entrenador) {
        if (entrenadorRepository.existsById(id_entrenador)) {
            entrenadorRepository.deleteById(id_entrenador);
        } else {
            throw new RuntimeException("Id no asignada " + id_entrenador);
        }
    }
    public Entrenador actualizar(long id_entrenador, Entrenador entrenador) {
        if (entrenadorRepository.existsById(id_entrenador)) {
            entrenador.setId_entrenador(id_entrenador);
            return entrenadorRepository.save(entrenador);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }

}
