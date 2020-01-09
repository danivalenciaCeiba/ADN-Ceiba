import { TestBed } from '@angular/core/testing';

import { GuardarDistribuidorService } from './guardar-distribuidor.service';

describe('GuardarDistribuidorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GuardarDistribuidorService = TestBed.get(GuardarDistribuidorService);
    expect(service).toBeTruthy();
  });
});
