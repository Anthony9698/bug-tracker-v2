import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninComponent } from './components/auth/signin/signin.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavigatorComponent } from './components/navigation/navigator/navigator.component';
import { LayoutComponent } from './components/layout/layout.component';
import { ManageProductRolesComponent } from './components/layout/manage-product-roles/manage-product-roles.component';
import { ManageProjectUsersComponent } from './components/layout/manage-project-users/manage-project-users.component';
import { MyProjectsComponent } from './components/layout/my-projects/my-projects.component';
import { MyTicketsComponent } from './components/layout/my-tickets/my-tickets.component';
import { ProfileComponent } from './components/layout/profile/profile.component';

@NgModule({
  declarations: [AppComponent, SigninComponent, RegisterComponent, DashboardComponent, NavigatorComponent, LayoutComponent, ManageProductRolesComponent, ManageProjectUsersComponent, MyProjectsComponent, MyTicketsComponent, ProfileComponent],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
