package com.example.apicosmeticos.services;

import com.example.apicosmeticos.dto.MarcaDto;
import com.example.apicosmeticos.dto.ProductoDto;
import com.example.apicosmeticos.entities.Categoria;
import com.example.apicosmeticos.entities.Marca;
import com.example.apicosmeticos.entities.Producto;
import com.example.apicosmeticos.repositories.CategoriaRepository;
import com.example.apicosmeticos.repositories.MarcaRepository;
import com.example.apicosmeticos.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;
    @Autowired
    private CategoriaRepository repositorycategoria;
    @Autowired
    private MarcaRepository repositorymarca;
    public List<Producto> getAll(){
        return repository.getAllByStatus();
    }
    public Producto crearProducto(ProductoDto productoDto){
        if(repositorycategoria.findById(productoDto.getId_categoria()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",productoDto.getId_categoria()));
        }
        if(repositorymarca.findById(productoDto.getId_marca()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",productoDto.getId_marca()));
        }
        Producto producto=new Producto();
        return getProducto(productoDto,producto);

    }
    public Producto actualizarProducto(Integer id,ProductoDto productoDto){
        if (repository.findById(id).isPresent()) {
            Producto producto = repository.getReferenceById(id);
            return getProducto(productoDto,producto);

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",id));
        }
    }
    public Producto eliminarProducto(Integer id){
        if(repository.findById(id).isPresent()){
            Producto producto = repository.getReferenceById(id);
            producto.setStatus((byte) 0);
            return repository.save(producto);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("REGISTRO NO ENCONTRADO",id));
        }
    }
    public Producto getProducto(ProductoDto productoDto,Producto producto){
        producto.setNombre(productoDto.getNombre());
        producto.setPrecio(productoDto.getPrecio());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setId_categoria(repositorycategoria.findById(productoDto.getId_categoria()).get());
        producto.setId_marca(repositorymarca.findById(productoDto.getId_marca()).get());
        producto.setStatus(productoDto.getStatus());
        return repository.save(producto);
    }
}


