import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaComponent } from './lista/lista.component';
import { FormularioComponent } from './formulario/formulario.component';

const routes: Routes = [
  {
    path: '',
    component: ListaComponent
  },
  {
    path: 'formulario',
    component: FormularioComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CargasRoutingModule { }
