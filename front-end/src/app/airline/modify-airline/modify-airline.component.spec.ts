import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyAirlineComponent } from './modify-airline.component';

describe('ModifyAirlineComponent', () => {
  let component: ModifyAirlineComponent;
  let fixture: ComponentFixture<ModifyAirlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyAirlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyAirlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
