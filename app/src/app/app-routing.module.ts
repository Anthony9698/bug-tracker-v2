import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/auth/register/register.component';
import { SigninComponent } from './components/auth/signin/signin.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { TicketsComponent } from './components/tickets/tickets.component';
import { AuthGuard } from './guards/auth/auth.guard';

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
    canActivate: [AuthGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent,
      },
      {
        path: 'projects',
        component: ProjectsComponent,
      },
      {
        path: 'tickets',
        component: TicketsComponent,
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
