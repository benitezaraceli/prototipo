package com.gylgroup.demo.repository;

import com.gylgroup.demo.entity.CuentaInversor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaInversorRepository extends JpaRepository<CuentaInversor, Long> {

}
