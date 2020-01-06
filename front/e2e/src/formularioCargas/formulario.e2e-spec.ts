import { FormularioPage } from './formulario.po';
import { browser, logging } from 'protractor';

describe('Formulario de cargas', () => {
	let page: FormularioPage;

	beforeEach(() => {
		page = new FormularioPage();
	});	

	afterEach(async () => {
		// Assert that there are no errors emitted from the browser
		const logs = await browser.manage().logs().get(logging.Type.BROWSER);
		expect(logs).not.toContain(jasmine.objectContaining({
			level: logging.Level.SEVERE,
		} as logging.Entry));
	});

	it('Debe contener el título del formulario de la carga', () => {
		page.navigateTo("1/cargas/formulario");		
		expect(page.obtenerTituloNuevaCarga().isPresent()).toBe(true);	
	});
		
	
	it('Debe mostrar mensaje de éxito al guardar una carga', () => {
		page.llenarCampos();
		page.obtenerBotonGuardarCarga().click();
		expect(page.obtenerMensajeSweetAlert()).toEqual('Carga almacenada correctamente');		
	});
});
