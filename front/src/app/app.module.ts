import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TranslateModule, TranslateLoader } from "@ngx-translate/core";
import { TranslateHttpLoader } from "@ngx-translate/http-loader";
import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { HttpModule } from "@angular/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { DistribuidoresModule } from './distribuidores/distribuidores.module';
import { SharedModule } from './shared/shared.module';

//Reactive forms
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

defineLocale("es", esLocale);
registerLocaleData(es);

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
		HttpModule,
		HttpClientModule,
		AppRoutingModule,
		AppRoutingModule,
		DistribuidoresModule,
		SharedModule,
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TranslateModule.forRoot({
			loader: {
				provide: TranslateLoader,
				useFactory: HttpLoaderFactory,
				deps: [HttpClient]
			}
		})
  ],
  providers: [{
			provide: LOCALE_ID,
			useValue: "es-ES"
		}],
  bootstrap: [AppComponent]
})
export class AppModule { }

// required for AOT compilation
export function HttpLoaderFactory(http: HttpClient) {
	return new TranslateHttpLoader(http, "./assets/i18n/", ".json");
}
