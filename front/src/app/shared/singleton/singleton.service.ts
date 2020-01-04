import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SingletonService {
	public distribuidor = {id:0,nit:"",nombre:"",ciudad:"",cumpleanios:""};
	public home:boolean = true;
  constructor() { }
}
