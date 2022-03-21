import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { LoginUserDto } from 'src/app/models/user/auth/login-user-dto';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss'],
})
export class SigninComponent implements OnInit {
  loginForm: FormGroup;
  submitted: boolean;
  invalidCredentials: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
    this.submitted = false;
    this.invalidCredentials = false;
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(10),
        ],
      ],
      password: ['', [Validators.required]],
    });
  }

  get username(): AbstractControl | null {
    return this.loginForm.get('username');
  }

  get password(): AbstractControl | null {
    return this.loginForm.get('password');
  }

  onLogin() {
    this.submitted = true;
    if (this.loginForm.valid) {
      let loginUserDto: LoginUserDto = new LoginUserDto(
        this.username?.value,
        this.password?.value
      );
      this.authService.login(loginUserDto).subscribe(
        (res) => console.log(res),
        (err) => (this.invalidCredentials = true)
      );
    }
  }
}
