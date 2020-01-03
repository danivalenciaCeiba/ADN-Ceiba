import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';
import swal from "sweetalert2";
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class BuscarPorNitService {
	public result = {status:true,id:0,cargas:[],nit:"",nombre:"",ciudad:"",cumpleanios:""};
  constructor(private service: RestService,private translate:TranslateService) { }

	/**
   * Buscar por 
   *
   *
   */
  buscarPorNit(nit) {        
	console.log(nit);
    let url = `/distribuidores/${nit}/buscar-por-nit`;
    this.service.queryGet(url).subscribe(
      response => {
        let result = response;
		this.result.status = true;
		this.result.id = JSON.parse(result["_body"]).id;
		this.result.cargas = JSON.parse(result["_body"]).cargas;
		this.result.nit = JSON.parse(result["_body"]).nit;
		this.result.nombre = JSON.parse(result["_body"]).nombre;
		this.result.ciudad = JSON.parse(result["_body"]).ciudad;
		this.result.cumpleanios = JSON.parse(result["_body"]).cumpleanios;
      },
      err => {
       	let error = err._body;
		this.result.status = false;
      }
    );
  }
}
