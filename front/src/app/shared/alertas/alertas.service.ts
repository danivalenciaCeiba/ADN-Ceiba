import { Injectable } from '@angular/core';
import swal from "sweetalert2";

@Injectable({
  providedIn: 'root'
})
export class AlertasService {

  constructor() { }

	public mostrarAlerta(titulo:string,tipo:any,mensaje:string){
		return swal({
						title: titulo,
						text: mensaje,
						type: tipo,
						showCancelButton: false,
						confirmButtonColor: "#3085d6",
						cancelButtonColor: "#d33",
						confirmButtonText: "Aceptar",
					});
	}
}
