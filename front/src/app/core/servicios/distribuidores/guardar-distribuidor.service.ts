import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';

@Injectable({
	providedIn: 'root'
})
export class GuardarDistribuidorService {

	constructor(private service: RestService) { }

	/**
	   * Listar cargas por el id de distribuidor
	   *
	   *
	   */
	guardar(distribuidor) {

		let url = `/distribuidores`;
		return this.service.queryPostRegular(url, distribuidor);
	}
}
