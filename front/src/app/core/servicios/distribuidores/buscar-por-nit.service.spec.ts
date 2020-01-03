import { TestBed } from '@angular/core/testing';

import { BuscarPorNitService } from './buscar-por-nit.service';

describe('BuscarPorNitService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BuscarPorNitService = TestBed.get(BuscarPorNitService);
    expect(service).toBeTruthy();
  });
});
