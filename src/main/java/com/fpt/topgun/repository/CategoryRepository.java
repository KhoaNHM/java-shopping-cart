package com.fpt.topgun.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.topgun.entity.Category;
public interface CategoryRepository extends JpaRepository<Category,Integer> {

  Category findByidCategory(int idCategory);
  
  List<Category> findByname(String name);

  @Transactional
  Long deleteByName(String name);
  
}
