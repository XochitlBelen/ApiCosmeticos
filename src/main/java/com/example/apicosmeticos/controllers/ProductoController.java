package com.example.apicosmeticos.controllers;

import com.example.apicosmeticos.dto.MarcaDto;
import com.example.apicosmeticos.dto.ProductoDto;
import com.example.apicosmeticos.entities.Marca;
import com.example.apicosmeticos.entities.Producto;
import com.example.apicosmeticos.services.MarcaService;
import com.example.apicosmeticos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService service;
    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDto productoDto){
        return new ResponseEntity<>(service.crearProducto(productoDto),HttpStatus.CREATED);

    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id")Integer id,@RequestBody ProductoDto productoDto){
        return new ResponseEntity<>(service.actualizarProducto(id, productoDto),HttpStatus.OK);
    }
    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.eliminarProducto(id),HttpStatus.OK);
    }
}
