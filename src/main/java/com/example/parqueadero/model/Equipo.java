package com.example.parqueadero.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "ciudad", length = 100, nullable = false)
    private String ciudad;
    @Column(name = "fundacion", nullable = false)
    private LocalDate fundacion;

    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipoModel")
    @JsonManagedReference
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal")
    @JsonManagedReference("local")
    private List<Partido> partidosComoLocal;

    @OneToMany(mappedBy = "equipoVisita")
    @JsonManagedReference("visita")
    private List<Partido> partidosComoVisitante;

    public long getId_equipo() {
        return id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public List<Partido> getPartidosComoLocal() {
        return partidosComoLocal;
    }

    public List<Partido> getPartidosComoVisitante() {
        return partidosComoVisitante;
    }

    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public void setPartidosComoLocal(List<Partido> partidosComoLocal) {
        this.partidosComoLocal = partidosComoLocal;
    }

    public void setPartidosComoVisitante(List<Partido> partidosComoVisitante) {
        this.partidosComoVisitante = partidosComoVisitante;
    }

    public Equipo(long id_equipo, String nombre, String ciudad, LocalDate fundacion, List<Jugador> jugadores, List<Entrenador> entrenadores, List<Partido> partidosComoLocal, List<Partido> partidosComoVisitante) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
        this.jugadores = jugadores;
        this.entrenadores = entrenadores;
        this.partidosComoLocal = partidosComoLocal;
        this.partidosComoVisitante = partidosComoVisitante;
    }

    public Equipo() {

    }
}