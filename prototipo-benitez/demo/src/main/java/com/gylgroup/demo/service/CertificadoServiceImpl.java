package com.gylgroup.demo.service;

import com.gylgroup.demo.entity.Certificado;
import com.gylgroup.demo.entity.CuentaInversor;
import com.gylgroup.demo.repository.CertificadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author araceli
 * Clase que implementa los metodos de la interface CertificadoRepository
 */
@Service
@RequiredArgsConstructor
public class CertificadoServiceImpl implements CertificadoService{

    private final CertificadoRepository certificadoRepository;

    @Override
    public List<Certificado> findbyCuentaInversor(CuentaInversor cuentaInversor){
        return certificadoRepository.findByCuentaInversorOrderByFechaDesc(cuentaInversor);
    }

    @Override
    public Certificado getCertificado(Long id){
        return certificadoRepository.findById(id).orElse(null);
    }

    @Override
    public String getCertificadoName(Long id){
        Certificado certificadoDB = getCertificado(id);
        if(certificadoDB == null){
            return null;
        }else{
            return certificadoDB.getNombreDocumento();
        }
    }
}
