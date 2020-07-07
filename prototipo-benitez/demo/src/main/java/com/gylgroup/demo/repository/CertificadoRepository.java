package com.gylgroup.demo.repository;

import com.gylgroup.demo.entity.Certificado;
import com.gylgroup.demo.entity.CuentaInversor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    List<Certificado> findByCuentaInversorOrderByFechaDesc(CuentaInversor cuentaInversor);

}
