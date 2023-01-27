import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmoothieDetailsComponent } from './smoothie-details.component';

describe('SmoothieDetailsComponent', () => {
  let component: SmoothieDetailsComponent;
  let fixture: ComponentFixture<SmoothieDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmoothieDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmoothieDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
