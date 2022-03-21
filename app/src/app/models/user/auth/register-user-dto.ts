import { LoginUserDto } from './login-user-dto';

export class RegisterUserDto extends LoginUserDto {
  firstName: string;
  lastName: string;
  email: string;
}
