package com.amdocs.cargomanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.cargomanagement.entity.*;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
