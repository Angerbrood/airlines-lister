import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteAirlineComponent } from './delete-airline.component';

describe('DeleteAirlineComponent', () => {
  let component: DeleteAirlineComponent;
  let fixture: ComponentFixture<DeleteAirlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteAirlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteAirlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
