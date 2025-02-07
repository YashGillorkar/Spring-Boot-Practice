package com.pratice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratice.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
