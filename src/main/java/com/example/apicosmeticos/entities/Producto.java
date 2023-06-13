package com.example.apicosmeticos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "producto")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precio")
    private float precio;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria id_categoria;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca id_marca;
    @Column(name = "status")
    private Byte status;
}
