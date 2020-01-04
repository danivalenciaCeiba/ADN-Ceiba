import { TestBed } from '@angular/core/testing';

import { ListarPorDistribuidorService } from './listar-por-distribuidor.service';

describe('ListarPorDistribuidorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ListarPorDistribuidorService = TestBed.get(ListarPorDistribuidorService);
    expect(service).toBeTruthy();
  });
});
