import { TestBed } from '@angular/core/testing';

import { GetAllServiceService } from './get-all-service.service';

describe('GetAllServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetAllServiceService = TestBed.get(GetAllServiceService);
    expect(service).toBeTruthy();
  });
});
