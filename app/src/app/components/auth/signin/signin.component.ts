import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss'],
})
export class SigninComponent implements OnInit {
  signForm: FormGroup;
  user: User;
  submitted: boolean;

  constructor(private formBuilder: FormBuilder) {
    this.user = new User('', '', '', '');
    this.submitted = false;
  }

  ngOnInit(): void {
    this.signForm = this.formBuilder.group({
      email: [this.user.email, [Validators.required]],
      password: [this.user.password, [Validators.required]],
    });
  }

  get email(): AbstractControl | null {
    return this.signForm.get('email');
  }

  get password(): AbstractControl | null {
    return this.signForm.get('password');
  }

  onSubmit() {}
}
