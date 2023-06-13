package com.example.apicosmeticos.services;

import com.example.apicosmeticos.dto.CategoriaDto;
import com.example.apicosmeticos.dto.MarcaDto;
import com.example.apicosmeticos.entities.Categoria;
import com.example.apicosmeticos.entities.Marca;
import com.example.apicosmeticos.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;
    public List<Marca> getAll(){
        return repository.getAllByStatus();

    }
    public Marca crearMarca(MarcaDto marcaDto){
        Marca marca = new Marca();
        marca.setNombre(marcaDto.getNombre());
        marca.setStatus(marcaDto.getStatus());
        return repository.save(marca);
    }
    public Marca actualizarMarca(Integer id,MarcaDto marcaDto){
        if(repository.findById(id).isPresent()){
            Marca marca = repository.getReferenceById(id);
            marca.setNombre(marcaDto.getNombre());
            marca.setStatus(marcaDto.getStatus());
            return repository.save(marca);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("MARCA NO ENCONTRADA", id));
        }
    }
    public Marca eliminarMarca(Integer id){
        if(repository.findById(id).isPresent()){
            Marca marca = repository.getReferenceById(id);
            marca.setStatus((byte) 0);
            return repository.save(marca);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",id));
        }
    }
}
