import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from 'src/app/models/user/user';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss'],
})
export class SigninComponent implements OnInit {
  signForm: FormGroup;
  user: User;

  constructor() {
    this.user = new User('', '', '', '');
  }

  ngOnInit(): void {
    this.signForm = new FormGroup({
      email: new FormControl(this.user.email),
      password: new FormControl(this.user.password),
    });
  }

  onSubmit() {
    console.log(this.signForm.value);
  }
}
