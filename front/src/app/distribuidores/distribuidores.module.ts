import { NgModule } from '@angular/core';
import { FormularioComponent } from './formulario/formulario.component';
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { CommonModule } from '@angular/common';
import { DatepickerModule, BsDatepickerModule } from 'ngx-bootstrap/datepicker';

import {
	ReactiveFormsModule,
	FormsModule,
	FormGroup,
	FormControl,
	Validators,
	FormBuilder
} from "@angular/forms";
import { SharedModule } from '../shared/shared.module';

//Idioma
import { esLocale } from "ngx-bootstrap/locale";
import { defineLocale } from "ngx-bootstrap/chronos";
import { LOCALE_ID } from "@angular/core";
import es from "@angular/common/locales/es";
import { registerLocaleData } from '@angular/common';
import { DistribuidoresRoutingModule } from './distribuidores-routing.module';

defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
	declarations: [FormularioComponent],
	exports: [FormularioComponent],
	imports: [
		FormsModule,
		HttpClientModule,
		DistribuidoresRoutingModule,
		ReactiveFormsModule, TranslateModule, CommonModule, SharedModule, BsDatepickerModule.forRoot(),
		DatepickerModule.forRoot()
	],
	providers: [{
			provide: LOCALE_ID,
			useValue: "es-ES"
		}]
})
export class DistribuidoresModule { }

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
	return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}
