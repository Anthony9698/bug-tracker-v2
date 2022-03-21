import { LoginUserDto } from './login-user-dto';

export class RegisterUserDto extends LoginUserDto {
  firstName: string;
  lastName: string;
  email: string;

  constructor(
    firstName: string,
    lastName: string,
    username: string,
    email: string,
    password: string
  ) {
    super(username, password);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
