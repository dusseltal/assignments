import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSmoothieComponent } from './create-smoothie.component';

describe('CreateSmoothieComponent', () => {
  let component: CreateSmoothieComponent;
  let fixture: ComponentFixture<CreateSmoothieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSmoothieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSmoothieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
