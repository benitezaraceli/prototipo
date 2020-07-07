package com.gylgroup.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author araceli
 * Clase del certificado  */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "tbl_certificado")

public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_documento")
    private String nombreDocumento;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_inversor_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private CuentaInversor cuentaInversor;
}
