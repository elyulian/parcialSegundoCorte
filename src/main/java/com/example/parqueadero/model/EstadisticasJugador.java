package com.example.parqueadero.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estadistica;
    @Column(name = "minutos_jugados", nullable = false)
    private int minutos_jugados;
    @Column(name = "goles", nullable = false)
    private int goles;
    @Column(name = "asistencias", nullable = false)
    private int asistencias;
    @Column(name = "tarjetas_amarillas", nullable = false)
    private int tarjetas_amarillas;
    @Column(name = "tarjetas_rojas", nullable = false)
    private int tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    @JsonBackReference("jugador-estadisticas")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    @JsonBackReference("partido-estadisticas")
    private Partido partido;

    public long getId_estadistica() {
        return id_estadistica;
    }

    public int getMinutos_jugados() {
        return minutos_jugados;
    }

    public int getGoles() {
        return goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getTarjetas_amarillas() {
        return tarjetas_amarillas;
    }

    public int getTarjetas_rojas() {
        return tarjetas_rojas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setId_estadistica(long id_estadistica) {
        this.id_estadistica = id_estadistica;
    }

    public void setMinutos_jugados(int minutos_jugados) {
        this.minutos_jugados = minutos_jugados;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public void setTarjetas_amarillas(int tarjetas_amarillas) {
        this.tarjetas_amarillas = tarjetas_amarillas;
    }

    public void setTarjetas_rojas(int tarjetas_rojas) {
        this.tarjetas_rojas = tarjetas_rojas;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
