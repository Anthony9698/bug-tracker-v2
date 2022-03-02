import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageProjectUsersComponent } from './manage-project-users.component';

describe('ManageProjectUsersComponent', () => {
  let component: ManageProjectUsersComponent;
  let fixture: ComponentFixture<ManageProjectUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManageProjectUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageProjectUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
