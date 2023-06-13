package com.example.apicosmeticos.repositories;

import com.example.apicosmeticos.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
    @Query("SELECT m FROM Marca m WHERE m.status=1")
    public List<Marca> getAllByStatus();
}
