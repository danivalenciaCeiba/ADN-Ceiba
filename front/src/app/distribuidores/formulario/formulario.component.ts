import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";

import { TranslateService } from "@ngx-translate/core";
import swal from "sweetalert2";
import { Router } from '@angular/router';
import { RestService } from 'src/app/core/servicios/rest.service';
import { BuscarPorNitService } from 'src/app/core/servicios/distribuidores/buscar-por-nit.service';
import { SingletonService } from 'src/app/shared/singleton/singleton.service';

@Component({
	selector: 'app-formulario',
	templateUrl: './formulario.component.html',
	styleUrls: ['./formulario.component.scss']
})
export class FormularioComponent implements OnInit {
	
	public nuevoDistribuidor: boolean = true;	
	public myForm: FormGroup;
	constructor(private service: RestService,
		private buscarPorNitService: BuscarPorNitService,
		private translate: TranslateService,
		private router: Router,
		private singleton: SingletonService) { }

	ngOnInit() {
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

		this.onChanges();
	}

	/**
	* Captura los cambios en el formulario
	*
	*
	 */
	onChanges(): void {
		this.myForm.get("nit").valueChanges.subscribe(val => {
			this.buscarPorNitService.buscarPorNit(val);
			let result = this.buscarPorNitService.result;
			let status = result.status;
			if (status) {
				this.nuevoDistribuidor = false;
				this.myForm.controls["nombre"].setValue(result.nombre);
				this.myForm.controls["ciudad"].setValue(result.ciudad);
				this.myForm.controls["cumpleanios"].setValue(result.cumpleanios);
				this.singleton.distribuidor = {id:result.id,nit:result.nit,nombre:result.nombre,ciudad:result.ciudad,cumpleanios:result.cumpleanios};
				
			} else {
				this.nuevoDistribuidor = true;
				this.singleton.distribuidor = {id:0,nit:"",nombre:"",ciudad:"",cumpleanios:""};
			}

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
		console.log(this.singleton.distribuidor);
		this.router.navigate(["/cargas"]);
	}

	/**
   * Guarda un nuevo distribuidor
   *
   *
   */
	store() {
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

		let url = `/distribuidores`;
		this.service.queryPostRegular(url, distribuidorData).subscribe(
			response => {
				let result = response;
				if (201 === result.status) {
					swal({
						title: this.translate.instant("alerts.success"),
						text: this.translate.instant("alerts.stored_distributor"),
						type: "success",
						showCancelButton: false,
						confirmButtonColor: "#3085d6",
						cancelButtonColor: "#d33",
						confirmButtonText: this.translate.instant("buttons.ok"),
					}).then(result => {
						this.nuevoDistribuidor = false;
						this.singleton.distribuidor = {id:result["_body"],nit:distribuidorData.nit,nombre:distribuidorData.nombre,ciudad:distribuidorData.ciudad,cumpleanios:distribuidorData.cumpleanios};
					});
				} else {
					swal({
						title: this.translate.instant("alerts.error"),
						text: this.translate.instant("alerts.cannot_delete_book"),
						type: "error",
						showCancelButton: false,
						confirmButtonColor: "#3085d6",
						cancelButtonColor: "#d33",
						confirmButtonText: this.translate.instant("buttons.ok"),
					}).then(result => {
						this.singleton.distribuidor = {id:0,nit:"",nombre:"",ciudad:"",cumpleanios:""};
						return false;
					});
				}
			},
			err => {
				this.singleton.distribuidor = {id:0,nit:"",nombre:"",ciudad:"",cumpleanios:""};
				let error = JSON.parse(err._body);
				swal({
					title: this.translate.instant("alerts.error"),
					text: error.message,
					type: "error",
					showCancelButton: false,
					confirmButtonColor: "#3085d6",
					cancelButtonColor: "#d33",
					confirmButtonText: this.translate.instant("buttons.ok"),
				}).then(result => {
					return false;
				});
			}
		);
	}

}
