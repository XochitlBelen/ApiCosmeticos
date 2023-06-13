package com.example.apicosmeticos.controllers;

import com.example.apicosmeticos.dto.CategoriaDto;
import com.example.apicosmeticos.entities.Categoria;
import com.example.apicosmeticos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.crearCategoria(categoriaDto),HttpStatus.CREATED);

    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable("id")Integer id,@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.actualizarCategoria(id, categoriaDto),HttpStatus.OK);
    }
    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.eliminarCategoria(id),HttpStatus.OK);
    }

}
