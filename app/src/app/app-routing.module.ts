import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/auth/register/register.component';
import { SigninComponent } from './components/auth/signin/signin.component';

const routes: Routes = [
  {
    component: SigninComponent,
    path: 'signin',
  },
  {
    component: RegisterComponent,
    path: 'register',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
