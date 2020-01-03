import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaComponent } from './lista/lista.component';
import { CargasRoutingModule } from './cargas-routing.module';



@NgModule({
	declarations: [ListaComponent],
	imports: [
		CommonModule,
		CargasRoutingModule
	],
	exports: [ListaComponent]
})
export class CargasModule { }
