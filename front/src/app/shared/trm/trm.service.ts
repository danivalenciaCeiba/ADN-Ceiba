import { Injectable } from '@angular/core';
import { Http } from "@angular/http";

@Injectable({
	providedIn: 'root'
})
export class TrmService {

	constructor(private http: Http) { }

	obtenerTrm() {
		let repos = this.http.get("https://crossorigin.me/http://app.docm.co/prod/Dmservices/Utilities.svc/GetTRM");
		return repos;
	}
}
