package com.example.apicosmeticos.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;
    private float precio;
    private String descripcion;
    private Integer id_categoria;
    private Integer id_marca;
    private byte status;

}
