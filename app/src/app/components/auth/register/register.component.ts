import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { RegisterUserDto } from 'src/app/models/user/auth/register-user-dto';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  newUser: RegisterUserDto;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      firstName: [this.newUser.firstName, [Validators.required]],
      lastName: [this.newUser.lastName, [Validators.required]],
      username: [
        this.newUser.username,
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(10),
        ],
      ],
      email: [this.newUser.email, [Validators.required, Validators.email]],
      passwordsForm: this.formBuilder.group(
        {
          password: [
            this.newUser.password,
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

  onSubmit() {}

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
