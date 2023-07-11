import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPersonInfoComponent } from './display-person-info.component';

describe('DisplayPersonInfoComponent', () => {
  let component: DisplayPersonInfoComponent;
  let fixture: ComponentFixture<DisplayPersonInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisplayPersonInfoComponent]
    });
    fixture = TestBed.createComponent(DisplayPersonInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
