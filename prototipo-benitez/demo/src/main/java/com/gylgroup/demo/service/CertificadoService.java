package com.gylgroup.demo.service;

import com.gylgroup.demo.entity.Certificado;
import com.gylgroup.demo.entity.CuentaInversor;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CertificadoService {

    List<Certificado> findbyCuentaInversor(CuentaInversor cuentaInversor);
    Certificado getCertificado(Long id);
    String getCertificadoName(Long id);

}
