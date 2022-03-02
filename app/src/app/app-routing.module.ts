import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/auth/register/register.component';
import { SigninComponent } from './components/auth/signin/signin.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ManageProductRolesComponent } from './components/layout/manage-product-roles/manage-product-roles.component';
import { ManageProjectUsersComponent } from './components/layout/manage-project-users/manage-project-users.component';
import { MyProjectsComponent } from './components/layout/my-projects/my-projects.component';
import { MyTicketsComponent } from './components/layout/my-tickets/my-tickets.component';
import { ProfileComponent } from './components/layout/profile/profile.component';

const routes: Routes = [
  {
    component: SigninComponent,
    path: 'signin',
  },
  {
    component: RegisterComponent,
    path: 'register',
  },
  {
    component: LayoutComponent,
    path: '',
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
      },
      {
        path: 'manage-project-roles',
        component: ManageProductRolesComponent,
      },
      {
        path: 'manage-project-users',
        component: ManageProjectUsersComponent,
      },
      {
        path: 'my-projects',
        component: MyProjectsComponent,
      },
      {
        path: 'my-tickets',
        component: MyTicketsComponent,
      },
      {
        path: 'profile',
        component: ProfileComponent,
      },
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
