import { Component, AfterViewInit } from '@angular/core';
import { SingletonService } from './shared/singleton/singleton.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent{
	title = 'front';
	
	constructor(public singleton:SingletonService){}
}