import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TablaInversionesComponent } from './tabla-inversiones/tabla-inversiones.component';
import { TablaCertificadosComponent } from './tabla-certificados/tabla-certificados.component';
import { BarraNavegacionComponent } from './barra-navegacion/barra-navegacion.component';

const rutasApp: Routes = [
  { path: 'tabla-inversiones', component: TablaInversionesComponent },
  { path: 'tabla-certificados/:id', component: TablaCertificadosComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  declarations: [
    AppComponent,
    TablaInversionesComponent,
    BarraNavegacionComponent,
    TablaCertificadosComponent
  ],
  imports: [
    RouterModule.forRoot(rutasApp),
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    HttpClient
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
