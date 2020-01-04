import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';

@Injectable({
  providedIn: 'root'
})
export class GuardarCargaService {

  constructor(private service: RestService) { }


	/**
   * Listar cargas por el id de distribuidor
   *
   *
   */
	guardar(carga) {

		let url = `/cargas`;
		return this.service.queryPostRegular(url,carga);
	}
}
