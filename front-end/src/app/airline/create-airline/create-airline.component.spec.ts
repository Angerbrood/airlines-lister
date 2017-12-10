import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAirlineComponent } from './create-airline.component';

describe('CreateAirlineComponent', () => {
  let component: CreateAirlineComponent;
  let fixture: ComponentFixture<CreateAirlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAirlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAirlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
