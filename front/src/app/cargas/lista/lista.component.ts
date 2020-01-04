import { Component, OnInit } from '@angular/core';
import { ListarPorDistribuidorService } from 'src/app/core/servicios/cargas/listar-por-distribuidor.service';
import { SingletonService } from 'src/app/shared/singleton/singleton.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-lista',
	templateUrl: './lista.component.html',
	styleUrls: ['./lista.component.scss']
})
export class ListaComponent implements OnInit {
	public cargas = [];
	public distribuidorId:number;
	public distribuidorNombre:string;
	constructor(private listarPorDistribuidorService: ListarPorDistribuidorService, public singleton: SingletonService, private route: ActivatedRoute) { }

	ngOnInit() {
		this.distribuidorNombre = localStorage.getItem("distribuidor-nombre");	
		localStorage.setItem('home', "0");
		this.singleton.home = false;
		this.route.params.subscribe(params =>{
			if(undefined !== params["distribuidor-id"]){
				this.distribuidorId = params["distribuidor-id"];
				this.listarPorDistribuidor(this.distribuidorId);
			}
		});
	}

	public listarPorDistribuidor(distribuidorId) {
		this.listarPorDistribuidorService.listarPorDistribuidor(distribuidorId).toPromise().then(res => {
			const result = res.json();
			this.cargas = result;
		}, err => {
			console.log(err);
		}
		);
	}

}
