import { ListaPage } from './lista.po';
import { browser, logging } from 'protractor';

describe('Lista de cargas', () => {
	let page: ListaPage;

	beforeEach(() => {
		page = new ListaPage();
	});	

	afterEach(async () => {
		// Assert that there are no errors emitted from the browser
		const logs = await browser.manage().logs().get(logging.Type.BROWSER);
		expect(logs).not.toContain(jasmine.objectContaining({
			level: logging.Level.SEVERE,
		} as logging.Entry));
	});

	it('Debe mostrar la lista con el botón de crear nueva carga', () => {
		page.navigateTo("1/cargas");		
		expect(page.obtenerBotonNuevaCarga().isPresent()).toBe(true);	
	});	
});
