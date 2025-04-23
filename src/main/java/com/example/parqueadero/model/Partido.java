package com.example.parqueadero.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "estadio",length = 100, nullable = false)
    private String estadio;
    @Column(name = "goles_local", nullable = false)
    private int goles_local;
    @Column(name = "goles_visita", nullable = false)
    private int goles_visita;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    @JsonBackReference("local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    @JsonBackReference("visita")
    private Equipo equipoVisita;

    @OneToMany(mappedBy = "partido")
    @JsonManagedReference("partido-estadisticas")
    private List<EstadisticasJugador> estadisticas;

    public Partido() {
    }

    public Partido(long id_partido, LocalDate fecha, String estadio, int goles_local, int goles_visita, Equipo equipoLocal, Equipo equipoVisita, List<EstadisticasJugador> estadisticas) {
        this.id_partido = id_partido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.goles_local = goles_local;
        this.goles_visita = goles_visita;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.estadisticas = estadisticas;
    }

    public void setId_partido(long id_partido) {
        this.id_partido = id_partido;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public void setGoles_visita(int goles_visita) {
        this.goles_visita = goles_visita;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public void setEstadisticas(List<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }

    public long getId_partido() {
        return id_partido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public int getGoles_visita() {
        return goles_visita;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public List<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }
}

