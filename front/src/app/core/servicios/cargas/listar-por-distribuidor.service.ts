import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';

@Injectable({
	providedIn: 'root'
})
export class ListarPorDistribuidorService {

	constructor(private service: RestService) { }

	/**
   * Listar cargas por el id de distribuidor
   *
   *
   */
	listarPorDistribuidor(distribuidorId) {

		let url = `/cargas/${distribuidorId}/listar`;
		return this.service.queryGet(url);
	}
}
