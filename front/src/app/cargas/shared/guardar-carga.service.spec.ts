import { TestBed } from '@angular/core/testing';

import { GuardarCargaService } from './guardar-carga.service';

describe('GuardarCargaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GuardarCargaService = TestBed.get(GuardarCargaService);
    expect(service).toBeTruthy();
  });
});
