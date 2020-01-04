import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { ListaComponent } from './lista/lista.component';
import { CargasRoutingModule } from './cargas-routing.module';
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { EstadoCargaPipe } from 'src/app/shared/pipes/estado-carga.pipe';
import { UiSwitchModule } from 'ngx-ui-switch';

import {
	ReactiveFormsModule,
	FormsModule,
	FormGroup,
	FormControl,
	Validators,
	FormBuilder
} from "@angular/forms";

//Idioma
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import { LOCALE_ID } from "@angular/core";
import es from "@angular/common/locales/es";
import { registerLocaleData } from '@angular/common';
import { FormularioComponent } from './formulario/formulario.component';

defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
	declarations: [ListaComponent, FormularioComponent,EstadoCargaPipe],
	imports: [
		FormsModule,
		CommonModule,
		CargasRoutingModule,
		UiSwitchModule,		
		ReactiveFormsModule,
		TranslateModule,
		HttpClientModule
	],
	exports: [ListaComponent,FormularioComponent],
	providers:[{
			provide: LOCALE_ID,
			useValue: "es-ES"
		}]
})
export class CargasModule { }

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
	return new TranslateHttpLoader(http, "../assets/i18n/", ".json");
}