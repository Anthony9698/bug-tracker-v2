import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginUserDto } from 'src/app/models/user/auth/login-user-dto';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private API_ENDPOINT = 'http://localhost:8080/api/auth';

  constructor(private httpClient: HttpClient) {}

  login(loginUserDto: LoginUserDto): Observable<any> {
    return this.httpClient.post<LoginUserDto>(
      `${this.API_ENDPOINT}/signin`,
      loginUserDto
    );
  }
}
