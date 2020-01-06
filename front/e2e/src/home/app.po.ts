import { browser, by, element } from 'protractor';

export class AppPage {
	navigateTo() {
		return browser.get(browser.baseUrl) as Promise<any>;
	}

	getTitleText() {
		return element(by.css('app-root .content span')).getText() as Promise<string>;
	}

	obtenerBotonGuardarDistribuidor() {
		return element(by.cssContainingText('button', 'Guardar'));
	}
	
	obtenerNitInput(){
		return element(by.css('input[formcontrolname="nit"]'));
	}
	
	obtenerNombreInput(){
		return element(by.css('input[formcontrolname="nombre"]'));
	}
	
	obtenerCiudadInput(){
		return element(by.css('input[formcontrolname="ciudad"]'));
	}
	
	obtenerCumpleaniosInput(){
		return element(by.css('input[formcontrolname="cumpleanios"]'));
	}
	
	obtenerMensajeSweetAlert(){
		return element(by.id("swal2-content")).getText();
	}
	
	obtenerBotonAceptarDistribuidorGuardado(){
		return element(by.className("swal2-confirm"));
	}
	
	obtenerBotonIngresar() {
		return element(by.cssContainingText('button', 'Ingresar'));
	}
	
	llenarCampos(){
		this.obtenerNitInput().sendKeys(1109296986);
		this.obtenerNombreInput().sendKeys("Daniel Mauricio Valencia");
		this.obtenerCiudadInput().sendKeys("Manizales");
		this.obtenerCumpleaniosInput().sendKeys("01/25/1992");
	}
	
	limpiarCampos(){
		this.obtenerNitInput().clear();
		this.obtenerNombreInput().clear();
		this.obtenerCiudadInput().clear();
		this.obtenerCumpleaniosInput().clear();
	}
}
