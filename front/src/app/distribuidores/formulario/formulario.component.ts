import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";

import { TranslateService } from "@ngx-translate/core";
import swal from "sweetalert2";
import { Router } from '@angular/router';
import { RestService } from 'src/app/core/servicios/rest.service';
import { BuscarPorNitService } from 'src/app/core/servicios/distribuidores/buscar-por-nit.service';
import { SingletonService } from 'src/app/shared/singleton/singleton.service';
import { GuardarDistribuidorService } from 'src/app/core/servicios/distribuidores/guardar-distribuidor.service';
import { AlertasService } from 'src/app/shared/alertas/alertas.service';
import { TrmService } from 'src/app/shared/trm/trm.service';

@Component({
	selector: 'app-formulario',
	templateUrl: './formulario.component.html',
	styleUrls: ['./formulario.component.scss']
})
export class FormularioComponent implements OnInit {

	public nuevoDistribuidor: boolean = true;
	public myForm: FormGroup;
	public trm: string;
	constructor(private service: RestService,
		private buscarPorNitService: BuscarPorNitService,
		private translate: TranslateService,
		private router: Router,
		private singleton: SingletonService,
		private guardarDistribuidorService: GuardarDistribuidorService,
		private alertasService: AlertasService,
		private trmService: TrmService) { }

	ngOnInit() {
		localStorage.setItem('home', "1");
		this.singleton.home = true;
		this.myForm = new FormGroup({
			nit: new FormControl("nit", [Validators.required]),
			nombre: new FormControl("nombre", [Validators.required]),
			ciudad: new FormControl("ciudad", [Validators.required]),
			cumpleanios: new FormControl("cumpleanios", [Validators.required])
		});

		this.myForm.controls["nit"].setValue(null);
		this.myForm.controls["nombre"].setValue(null);
		this.myForm.controls["ciudad"].setValue(null);
		this.myForm.controls["cumpleanios"].setValue(null);

		//Obtener TRM
		/*
		this.trmService.obtenerTrm().toPromise().then(res=>{			
			console.log(res);
		});*/

		this.onChanges();
	}

	/**
	* Captura los cambios en el formulario
	*
	*
	 */
	onChanges(): void {
		this.myForm.get("nit").valueChanges.subscribe(val => {
			if (null !== val) {
				this.buscarPorNitService.buscarPorNit(val).toPromise().then(result => {
					if ("" !== result["_body"]) {
						let distribuidor = result.json();
						this.nuevoDistribuidor = false;
						this.myForm.controls["nombre"].setValue(distribuidor.nombre);
						this.myForm.controls["ciudad"].setValue(distribuidor.ciudad);
						this.myForm.controls["cumpleanios"].setValue(distribuidor.cumpleanios);
						localStorage.setItem('distribuidor-nombre', distribuidor.nombre);
						this.singleton.distribuidor = { id: distribuidor.id, nit: distribuidor.nit, nombre: distribuidor.nombre, ciudad: distribuidor.ciudad, cumpleanios: distribuidor.cumpleanios };
					} else {
						this.nuevoDistribuidor = true;
						this.singleton.distribuidor = { id: 0, nit: "", nombre: "", ciudad: "", cumpleanios: "" };
					}
				});
			}
		}, err => {
			this.nuevoDistribuidor = true;
			this.singleton.distribuidor = { id: 0, nit: "", nombre: "", ciudad: "", cumpleanios: "" };
		});
	}

	/**
	   * Valida si un campo cumple con las reglas de validación
	   *
	   * @param controlName nombre del control que está siendo evaluado
	   * @param validationType tipo de validación que se lleva a cabo
	   */
	public controlHasError(controlName: string, validationType: string): boolean {
		const control = this.myForm.controls[controlName];
		if (!control) {
			return false;
		}

		const result =
			control.hasError(validationType) && (control.dirty || control.touched);
	
		return result;
	}

	public verCargas() {
		this.router.navigate([`/${this.singleton.distribuidor.id}/cargas`]);
	}

	/**
   * Guarda un nuevo distribuidor
   *
   *
   */
	guardar() {
		let controls = this.myForm.controls;
		if (this.myForm.invalid) {
			Object.keys(controls).forEach(controlName =>
				controls[controlName].markAsTouched()
			);
			return;
		}

		const distribuidorData = {
			nit: controls["nit"].value,
			nombre: controls["nombre"].value,
			ciudad: controls["ciudad"].value,
			//cumpleanios: controls["cumpleanios"].value
			cumpleanios: "1995-01-25"
		};

		this.guardarDistribuidorService.guardar(distribuidorData).toPromise().then(res => {
			const result = res;
			if (201 === result.status) {
				this.alertasService.mostrarAlerta("Exito", "success", "Distribuidor almacenado correctamente").then(res => {
					this.nuevoDistribuidor = false;
					let distribuidorId = result["_body"];
					this.singleton.distribuidor = { id: distribuidorId, nit: distribuidorData.nit, nombre: distribuidorData.nombre, ciudad: distribuidorData.ciudad, cumpleanios: distribuidorData.cumpleanios };
					localStorage.setItem('distribuidor-nombre', distribuidorData.nombre);
				});
			} else {
				this.alertasService.mostrarAlerta("Error", "error", result["_body"]).then(res => {
					this.singleton.distribuidor = { id: 0, nit: "", nombre: "", ciudad: "", cumpleanios: "" };
					return false;
				});
			}
		}, err => {
			this.singleton.distribuidor = { id: 0, nit: "", nombre: "", ciudad: "", cumpleanios: "" };
			let error = JSON.parse(err._body);
			this.alertasService.mostrarAlerta("Error", "error", error.message).then(res => {
				return false;
			});
		});
	}

}
