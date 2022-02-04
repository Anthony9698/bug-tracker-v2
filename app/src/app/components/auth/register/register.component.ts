import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  newUser: User;
  confirmPassword: string;
  submitted: boolean;

  constructor(private formBuilder: FormBuilder) {
    this.newUser = new User('', '', '', '');
    this.confirmPassword = '';
    this.submitted = false;
  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      firstName: [this.newUser.firstName, [Validators.required]],
      lastName: [this.newUser.lastName, [Validators.required]],
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
          confirmPassword: [
            this.confirmPassword,
            [
              Validators.required,
              Validators.minLength(8),
              Validators.maxLength(25),
            ],
          ],
        },
        {
          validators: this.passwordsMatch('password', 'confirmPassword'),
        }
      ),
    });
    console.log(this.submitted);
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.registerForm.get('firstName'));
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

      if (input.value !== matchingInput.value) {
        matchingInput.setErrors({ confirmedValidator: true });
        return { confirmedValidator: true };
      } else {
        matchingInput.setErrors(null);
        return null;
      }
    };
  }
}
