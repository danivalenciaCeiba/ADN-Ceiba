import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestService } from './servicios/rest.service';
import { BuscarPorNitService } from './servicios/distribuidores/buscar-por-nit.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
	providers: [RestService,BuscarPorNitService],
})
export class CoreModule { }
