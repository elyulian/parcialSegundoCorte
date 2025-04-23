package com.example.parqueadero.repository;

import com.example.parqueadero.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = "SELECT SUM(goles_local) FROM partido WHERE equipo_local = :idEquipo", nativeQuery = true)
    Integer totalGolesComoLocal(@Param("idEquipo") Long idEquipo);

    @Query(value = "SELECT SUM(goles_visita) FROM partido WHERE equipo_visita = :idEquipo", nativeQuery = true)
    Integer totalGolesComoVisitante(@Param("idEquipo") Long idEquipo);

    @Query(value = "SELECT p.id_partido, e1.nombre AS equipo_local, e2.nombre AS equipo_visita, " +
            "p.goles_local, p.goles_visita, p.fecha " +
            "FROM partido p " +
            "JOIN equipo e1 ON p.equipo_local = e1.id_equipo " +
            "JOIN equipo e2 ON p.equipo_visita = e2.id_equipo", nativeQuery = true)
    List<Object[]> obtenerResultadosPartidos();
}

