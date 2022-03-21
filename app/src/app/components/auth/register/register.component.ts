import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { RegisterUserDto } from 'src/app/models/user/auth/register-user-dto';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {
    this.submitted = false;
  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      username: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(10),
        ],
      ],
      email: ['', [Validators.required, Validators.email]],
      passwordsForm: this.formBuilder.group(
        {
          password: [
            '',
            [
              Validators.required,
              Validators.minLength(8),
              Validators.maxLength(25),
            ],
          ],
          confirmPassword: ['', [Validators.required]],
        },
        {
          validators: this.passwordsMatch('password', 'confirmPassword'),
        }
      ),
    });
  }

  get firstName(): AbstractControl | null {
    return this.registerForm.get('firstName');
  }

  get lastName(): AbstractControl | null {
    return this.registerForm.get('lastName');
  }

  get username(): AbstractControl | null {
    return this.registerForm.get('username');
  }

  get email(): AbstractControl | null {
    return this.registerForm.get('email');
  }

  get password(): AbstractControl | null {
    return this.registerForm.get(['passwordsForm', 'password']);
  }

  get confirmPassword(): AbstractControl | null {
    return this.registerForm.get(['passwordsForm', 'confirmPassword']);
  }

  onRegister() {
    this.submitted = true;
    if (this.registerForm.valid) {
      let registerUserDto: RegisterUserDto = new RegisterUserDto(
        this.firstName?.value,
        this.lastName?.value,
        this.username?.value,
        this.email?.value,
        this.password?.value
      );
      this.authService
        .register(registerUserDto)
        .subscribe((res) => console.log(res));
    }
  }

  passwordsMatch(controlName: string, matchingControlName: string) {
    return (control: AbstractControl): ValidationErrors | null => {
      let input = control.get(controlName);
      let matchingInput = control.get(matchingControlName);

      if (input === null || matchingInput == null) {
        return null;
      }

      if (matchingInput.errors && !matchingInput.errors.confirmedValidator) {
        return null;
      }

      if (input.value !== matchingInput.value || input.errors) {
        matchingInput.setErrors({ passwordsMatch: true });
        return { passwordsMatch: true };
      } else {
        matchingInput.setErrors(null);
        return null;
      }
    };
  }
}
