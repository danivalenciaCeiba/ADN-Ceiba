import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class BuscarPorNitService {
	public result = {status:true,id:0,cargas:[],nit:"",nombre:"",ciudad:"",cumpleanios:""};
  constructor(private service: RestService,private translate:TranslateService) { }

	/**
   * Buscar un distribuidor por su nit
   *
   *
   */
  buscarPorNit(nit) {        
    let url = `/distribuidores/${nit}/buscar-por-nit`;
    return this.service.queryGet(url);
  }
}
