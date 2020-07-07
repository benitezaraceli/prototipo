import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaInversionesComponent } from './tabla-inversiones.component';

describe('TablaInversionesComponent', () => {
  let component: TablaInversionesComponent;
  let fixture: ComponentFixture<TablaInversionesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablaInversionesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablaInversionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
