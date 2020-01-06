import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { UiSwitchModule } from 'ngx-ui-switch';
import { ActivatedRoute, Router } from '@angular/router';
import { GuardarCargaService } from 'src/app/core/servicios/cargas/guardar-carga.service';
import { AlertasService } from 'src/app/shared/alertas/alertas.service';
import { SingletonService } from 'src/app/shared/singleton/singleton.service';
import { TranslateService } from '@ngx-translate/core';

@Component({
	selector: 'app-formulario',
	templateUrl: './formulario.component.html',
	styleUrls: ['./formulario.component.scss']
})
export class FormularioComponent implements OnInit {
	private distribuidorId: number;
	public distribuidorNombre: string;
	public myForm: FormGroup;
	constructor(private route: ActivatedRoute, private guardarCargaService: GuardarCargaService, private alertasService: AlertasService, private router: Router, public singleton: SingletonService, public translate: TranslateService) { }

	ngOnInit() {
		this.distribuidorNombre = localStorage.getItem("distribuidor-nombre");
		localStorage.setItem('home', "0");
		this.singleton.home = false;
		this.myForm = new FormGroup({
			peso: new FormControl("peso", [Validators.required]),
			descripcion: new FormControl("descripcion", [Validators.required]),
			precio: new FormControl("precio", [Validators.required]),
			estado: new FormControl("estado", [Validators.required])
		});

		this.myForm.controls["peso"].setValue(null);
		this.myForm.controls["descripcion"].setValue(null);
		this.myForm.controls["precio"].setValue(null);
		this.myForm.controls["estado"].setValue(true);

		this.route.params.subscribe(params => {
			if (undefined !== params["distribuidor-id"]) {
				this.distribuidorId = params["distribuidor-id"];
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

	public guardar() {
		let controls = this.myForm.controls;
		if (this.myForm.invalid) {
			Object.keys(controls).forEach(controlName =>
				controls[controlName].markAsTouched()
			);
			return;
		}

		const cargaData = {
			distribuidorId: this.distribuidorId,
			peso: controls["peso"].value,
			descripcion: controls["descripcion"].value,
			estado: controls["estado"].value ? 1 : 2,
			precio: controls["precio"].value
		};

		this.guardarCargaService.guardar(cargaData).toPromise().then(res => {
			const result = res;
			if (201 === result.status) {
				this.alertasService.mostrarAlerta("Exito", "success", result["_body"]).then(result => {
					this.router.navigate([`/${this.distribuidorId}/cargas`]);
				});
			} else {
				this.alertasService.mostrarAlerta("Error", "error", result["_body"]).then(result => {
					return false;
				});
			}
		}, err => {
			console.log(err);
		}
		);

	}

}
