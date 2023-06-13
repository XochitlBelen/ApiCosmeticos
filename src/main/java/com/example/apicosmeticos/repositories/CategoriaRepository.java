package com.example.apicosmeticos.repositories;

import com.example.apicosmeticos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    @Query("SELECT c FROM Categoria c WHERE c.status=1")
    public List<Categoria> getAllByStatus();
}
