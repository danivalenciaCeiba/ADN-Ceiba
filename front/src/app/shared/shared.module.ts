import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SingletonService } from './singleton/singleton.service';
import { EstadoCargaPipe } from './pipes/estado-carga.pipe';
import { AlertasService } from './alertas/alertas.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [SingletonService,EstadoCargaPipe,AlertasService],
})
export class SharedModule { }
