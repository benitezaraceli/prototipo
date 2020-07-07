import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-tabla-inversiones',
  templateUrl: './tabla-inversiones.component.html',
  styleUrls: ['./tabla-inversiones.component.css']
})
export class TablaInversionesComponent implements OnInit {

  inversiones: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.listarInversiones();
  }

  listarInversiones(){
    this.http.get('http://localhost:8080/certificado').subscribe(
      (respuesta: Response) => { this.inversiones = respuesta; },
      (respuesta: Response) => {
          alert('Ha ocurrido un error');
          console.log(respuesta.status);
      }
    );
  }
}
