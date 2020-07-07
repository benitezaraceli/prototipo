package com.gylgroup.demo.controller;

import com.gylgroup.demo.entity.Certificado;
import com.gylgroup.demo.entity.CuentaInversor;
import com.gylgroup.demo.service.CertificadoService;
import com.gylgroup.demo.service.CuentaInversorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/certificado")
@Api(tags = "certificado")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })

    public class CertificadoController {

    @Autowired
    private CertificadoService certificadoService;

    @Autowired
    private CuentaInversorService cuentaInversorService;

    /**
     * obtiene todos las cuentas inversores
     */
    @GetMapping(value = "")
    @ApiOperation(value = "Obtiene cuentas inversores", notes = "Obtiene todos las cuentas inversores")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Cuenta inversor obtenidas correctamente"),
            @ApiResponse(code = 404, message = "Solicitud invalida") })
    public ResponseEntity<List<CuentaInversor>> listCuentasInversor() {
        List<CuentaInversor> cuentasInversor = cuentaInversorService.listAllCuentasInversor();
        if (cuentasInversor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cuentasInversor);

    }

    /** se obtiene el certificado según el id de la cuenta inversor */
    @GetMapping(value = "/{cuentaInversorId}")
    @ApiOperation(value = "Obtiene certificado", notes = "Obtiene certificado según el id de la cuenta inversor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Certificados obtenidos correctamente"),
            @ApiResponse(code = 404, message = "Solicitud invalida") })
    public ResponseEntity<List<Certificado>> findbyCuentaInversor(@PathVariable Long cuentaInversorId) {
        List<Certificado> certificados = certificadoService.findbyCuentaInversor(CuentaInversor.builder().id(cuentaInversorId).build());
        if (certificados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(certificados);
    }

    /** se obtiene el certificado en pdf según el id */
    @GetMapping(value = "/download/{id}")
    @ApiOperation(value = "Obtiene certificado en PDF", notes = "Obtiene certificado según el id")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Certificado obtenido correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida") })
    public ResponseEntity<Object> downloadFile(@PathVariable Long id) throws IOException{
        String fileName = certificadoService.getCertificadoName(id);
        if (null == fileName) {
            return ResponseEntity.notFound().build();
        }
        String path = "C:/Users/Aldana/Documents/trabsjo/demo-icbc/pdfs/"+ fileName;
        File file = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf")).body(resource);

        return responseEntity;
    }
}