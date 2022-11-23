package com.example.seproject2022.repository;

import com.example.seproject2022.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {

    Optional<Product> findProductById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> findProductByName(String name);
}
