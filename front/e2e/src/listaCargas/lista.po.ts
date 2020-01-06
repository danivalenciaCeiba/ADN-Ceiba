import { browser, by, element } from 'protractor';

export class ListaPage {
	navigateTo(url:string) {
		return browser.get(browser.baseUrl+'/'+url) as Promise<any>;
	}

	obtenerBotonNuevaCarga() {
		return element(by.cssContainingText('button', 'Nueva carga'));
	}	
}
