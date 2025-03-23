package com.refaccionaria.refaccionariaapp.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface productoRepository extends JpaRepository<producto, Integer> {

    void deleteById(Integer id);

    Optional<producto> findById(Integer id);

    List<producto> findByStock(Integer stock);
}
