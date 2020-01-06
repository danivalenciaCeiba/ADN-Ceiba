import { browser, by, element } from 'protractor';

export class FormularioPage {
	navigateTo(url:string) {
		return browser.get(browser.baseUrl+'/'+url) as Promise<any>;
	}

	obtenerTituloNuevaCarga() {
		return element(by.cssContainingText('h1', 'Crear carga'));
	}	
	
	obtenerPesoInput(){
		return element(by.css('input[formcontrolname="peso"]'));
	}
	
	obtenerDescripcionInput(){
		return element(by.css('input[formcontrolname="descripcion"]'));
	}
	
	obtenerPrecioInput(){
		return element(by.css('input[formcontrolname="precio"]'));
	}
	
	llenarCampos(){		
		this.obtenerPesoInput().sendKeys(2000);
		this.obtenerDescripcionInput().sendKeys("Descripcion prueba protractor");
		this.obtenerPrecioInput().sendKeys(500000);
	}
	
	obtenerMensajeSweetAlert(){
		return element(by.id("swal2-content")).getText();
	}
	
	obtenerBotonGuardarCarga() {
		return element(by.cssContainingText('button', 'Guardar'));
	}
}
