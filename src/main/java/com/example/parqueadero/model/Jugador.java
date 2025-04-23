package com.example.parqueadero.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "posicion", length = 50, nullable = false)
    private String posicion;
    @Column(name = "dorsal", nullable = false)
    private int dorsal;
    @Column(name = "fecha_nac", nullable = false)
    private LocalDate fecha_nac;
    @Column(name = "nacionalidad", length = 100, nullable = false)
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    @JsonManagedReference("jugador-estadisticas")
    private List<EstadisticasJugador> estadisticas;

    public long getId_jugador() {
        return id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public List<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setId_jugador(long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setEstadisticas(List<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }

    public Jugador() {
    }

    public Jugador(long id_jugador, String nombre, String posicion, int dorsal, LocalDate fecha_nac, String nacionalidad, Equipo equipo, List<EstadisticasJugador> estadisticas) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.estadisticas = estadisticas;
    }

}
