import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { LoginUserDto } from 'src/app/models/user/auth/login-user-dto';
import { RegisterUserDto } from 'src/app/models/user/auth/register-user-dto';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private API_ENDPOINT = 'http://localhost:8080/api/auth';

  constructor(
    private httpClient: HttpClient,
    public jwtHelper: JwtHelperService
  ) {}

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token') || undefined;
    console.log(this.jwtHelper.decodeToken(token));
    return !this.jwtHelper.isTokenExpired(token);
  }

  login(loginUserDto: LoginUserDto): Observable<any> {
    return this.httpClient.post<LoginUserDto>(
      `${this.API_ENDPOINT}/signin`,
      loginUserDto
    );
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  register(registerUserDto: RegisterUserDto): Observable<any> {
    return this.httpClient.post<RegisterUserDto>(
      `${this.API_ENDPOINT}/signup`,
      registerUserDto
    );
  }
}
