import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageProductRolesComponent } from './manage-product-roles.component';

describe('ManageProductRolesComponent', () => {
  let component: ManageProductRolesComponent;
  let fixture: ComponentFixture<ManageProductRolesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageProductRolesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageProductRolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
