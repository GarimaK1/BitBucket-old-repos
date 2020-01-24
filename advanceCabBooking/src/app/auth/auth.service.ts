import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { AuthData } from "./auth-data.model";

@Injectable({
  providedIn: "root"
})
export class AuthService {

  private token: string;
  constructor(private http: HttpClient) {}

  createUser(email: string, password: string) {
    const newUser: AuthData = { email: email, password: password };
    this.http
      .post<{ message: string, document: any }>(
        "http://localhost:3000/api/user/signup",
        newUser
      )
      .subscribe(result => {
        console.log(result.message);
      });
  }

  loginUser(email: string, password: string) {
    const user: AuthData = {email, password};
    this.http.post<{token: string}>("http://localhost:3000/api/user/login", user)
    .subscribe(result => {
      console.log(result);
      const token = result.token;
      this.token = token;
    });
  }

  getToken() {
    return this.token;
  }
}
