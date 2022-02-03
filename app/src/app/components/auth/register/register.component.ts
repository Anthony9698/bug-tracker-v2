import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  newUser: User;

  constructor() {}

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      firstName: new FormControl(this.newUser.firstName),
      lastName: new FormControl(this.newUser.lastName),
      email: new FormControl(this.newUser.email),
      password: new FormControl(this.newUser.password),
      confirmPassword: new FormControl(this.newUser.password),
    });
  }

  get firstName() {
    return this.registerForm.get('firstName');
  }
}
