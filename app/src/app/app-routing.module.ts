import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/auth/register/register.component';
import { SigninComponent } from './components/auth/signin/signin.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavigatorComponent } from './components/navigation/navigator/navigator.component';

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
    component: DashboardComponent,
    path: '',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
