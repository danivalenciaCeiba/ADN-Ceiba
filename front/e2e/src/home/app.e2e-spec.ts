import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('Formulario de distribuidores', () => {
	let page: AppPage;

	beforeEach(() => {
		page = new AppPage();
	});	

	afterEach(async () => {
		// Assert that there are no errors emitted from the browser
		const logs = await browser.manage().logs().get(logging.Type.BROWSER);
		expect(logs).not.toContain(jasmine.objectContaining({
			level: logging.Level.SEVERE,
		} as logging.Entry));
	});

	it('Debe mostrar mensaje de exito al guardar un distribuidor', () => {
		page.navigateTo();
		page.llenarCampos();
		page.obtenerBotonGuardarDistribuidor().click();
		expect(page.obtenerMensajeSweetAlert()).toEqual('Distribuidor almacenado correctamente');		
	});
	
	it('Debe mostrar botón de ingresar al dar ok en el mensaje de guardado de un distribuidor',()=>{
		page.obtenerBotonAceptarDistribuidorGuardado().click();
		expect(page.obtenerBotonIngresar().isPresent()).toBe(true);
	});
	
	/*
	it('Debe mostrar mensaje de error al intentar guardar un distribuidor existente', () => {		
		page.limpiarCampos();		
		page.llenarCampos();
		browser.waitForAngular();
		page.obtenerBotonGuardarDistribuidor().click();
		expect(page.obtenerMensajeSweetAlert()).toEqual('El distribuidor ya existe en el sistema');		
	});*/
});
