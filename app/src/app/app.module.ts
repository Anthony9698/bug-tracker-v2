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
import { MyProjectsComponent } from './components/layout/my-projects/my-projects.component';
import { MyTicketsComponent } from './components/layout/my-tickets/my-tickets.component';
import { BannerComponent } from './components/navigation/banner/banner.component';

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    RegisterComponent,
    DashboardComponent,
    NavigatorComponent,
    LayoutComponent,
    MyProjectsComponent,
    MyTicketsComponent,
    BannerComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
