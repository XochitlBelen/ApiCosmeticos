package com.example.apicosmeticos.repositories;

import com.example.apicosmeticos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query("SELECT p FROM Producto p WHERE p.status=1")
    public List<Producto> getAllByStatus();
}
