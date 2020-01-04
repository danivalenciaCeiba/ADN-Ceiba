import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestService } from './servicios/rest.service';
import { BuscarPorNitService } from './servicios/distribuidores/buscar-por-nit.service';
import { ListarPorDistribuidorService } from './servicios/cargas/listar-por-distribuidor.service';
import { GuardarCargaService } from './servicios/cargas/guardar-carga.service';
import { GuardarDistribuidorService } from './servicios/distribuidores/guardar-distribuidor.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
	providers: [RestService,BuscarPorNitService,ListarPorDistribuidorService,GuardarCargaService,GuardarDistribuidorService],
})
export class CoreModule { }
