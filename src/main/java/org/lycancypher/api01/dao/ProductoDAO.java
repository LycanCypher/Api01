package org.lycancypher.api01.dao;

import org.lycancypher.api01.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDAO extends JpaRepository<Producto, Integer>{

}
