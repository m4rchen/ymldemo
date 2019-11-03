package com.example.ymldemo.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT DISTINCT item FROM Item item where item.name LIKE :name%")
    @Transactional(readOnly = true)
    List<Item> findByName(@Param("name") String name);
}
