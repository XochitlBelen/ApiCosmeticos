package com.example.apicosmeticos.controllers;

import com.example.apicosmeticos.dto.CategoriaDto;
import com.example.apicosmeticos.dto.MarcaDto;
import com.example.apicosmeticos.entities.Categoria;
import com.example.apicosmeticos.entities.Marca;
import com.example.apicosmeticos.services.CategoriaService;
import com.example.apicosmeticos.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService service;
    @GetMapping
    public ResponseEntity<List<Marca>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Marca> crearMarca(@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.crearMarca(marcaDto),HttpStatus.CREATED);

    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Marca> actualizarMarca(@PathVariable("id")Integer id,@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.actualizarMarca(id, marcaDto),HttpStatus.OK);
    }
    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Marca> eliminarMarca(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.eliminarMarca(id),HttpStatus.OK);
    }
}
