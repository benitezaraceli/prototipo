import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-tabla-certificados',
  templateUrl: './tabla-certificados.component.html',
  styleUrls: ['./tabla-certificados.component.css']
})
export class TablaCertificadosComponent implements OnInit {

  certificados: any;
  id: number;
  vacio = false;

  constructor(private http: HttpClient, private ruta: ActivatedRoute) { }

  ngOnInit(): void {
    this.ruta.params.subscribe(( params: Params) => {
      this.id = params.id;
    });
    this.listarCertificados(this.id);
  }

  listarCertificados(id){
    this.http.get('http://localhost:8080/certificado/' + id).subscribe(
      (respuesta: Response) => { this.certificados = respuesta; },
      (respuesta: Response) => {
        if (respuesta.status === 404) {
          this.vacio = true;
        }else{
          alert('Ha ocurrido un error');
          console.log(respuesta.status);
        }
      }
    );
  }



  obtenerCertificado(id){
    this.http.get('http://localhost:8080/certificado/download/' + id, { responseType: 'blob' as 'json' })
    .subscribe(
      (data: Blob) => {
        const archivo = new Blob([data], { type: 'application/pdf' });
        const urlArchivo = URL.createObjectURL(archivo);

        window.open(urlArchivo);
        const a       = document.createElement('a');
        a.href        = urlArchivo;
        a.target      = '_blank';
        a.download    = 'pdf.pdf';
        document.body.appendChild(a);
        a.click();
        },
      (error) => {
        console.log( 'obtenerCertificado error: ', error );
      }
    );
  }
}
