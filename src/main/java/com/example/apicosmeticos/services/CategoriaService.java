package com.example.apicosmeticos.services;

import com.example.apicosmeticos.dto.CategoriaDto;
import com.example.apicosmeticos.entities.Categoria;
import com.example.apicosmeticos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public List<Categoria> getAll(){
        return repository.getAllByStatus();
    }
    public Categoria crearCategoria(CategoriaDto categoriaDto){
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaDto.getDescripcion());
        categoria.setStatus(categoriaDto.getStatus());
        return repository.save(categoria);
    }
    public Categoria actualizarCategoria(Integer id,CategoriaDto categoriaDto){
        if(repository.findById(id).isPresent()){
            Categoria categoria = repository.getReferenceById(id);
            categoria.setDescripcion(categoriaDto.getDescripcion());
            categoria.setStatus(categoriaDto.getStatus());
            return repository.save(categoria);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",id));
        }
    }
    public Categoria eliminarCategoria(Integer id){
        if(repository.findById(id).isPresent()){
            Categoria categoria = repository.getReferenceById(id);
            categoria.setStatus((byte) 0);
            return repository.save(categoria);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",id));
        }
    }
}


