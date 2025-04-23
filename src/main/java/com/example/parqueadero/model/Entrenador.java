package com.example.parqueadero.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrenador;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "especialidad", length = 100, nullable = false)
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference
    private Equipo equipoModel;

    public Entrenador() {
    }

    public void setId_entrenador(long id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEquipoModel(Equipo equipoModel) {
        this.equipoModel = equipoModel;
    }

    public long getId_entrenador() {
        return id_entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Equipo getEquipoModel() {
        return equipoModel;
    }
}
