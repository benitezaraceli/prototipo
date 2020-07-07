package com.gylgroup.demo.service;

import com.gylgroup.demo.entity.CuentaInversor;
import com.gylgroup.demo.repository.CuentaInversorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author araceli
 * Clase que implementa los metodos de la interface CertificadoRepository
 */
@Service
@RequiredArgsConstructor
public class CuentaInversorServiceImpl  implements CuentaInversorService{

    private final CuentaInversorRepository cuentaInversorRepository;

    @Override
    public List<CuentaInversor> listAllCuentasInversor(){
        return cuentaInversorRepository.findAll();
    }
}