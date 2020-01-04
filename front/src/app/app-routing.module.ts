import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
	{
	    path: '',
	    loadChildren: () => import('./distribuidores/distribuidores.module').then(m => m.DistribuidoresModule)
	},
	{
	    path: ':distribuidor-id/cargas',
	    loadChildren: () => import('./cargas/cargas.module').then(m => m.CargasModule)
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
