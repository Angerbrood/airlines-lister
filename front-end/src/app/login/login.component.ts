import { Component, OnInit } from '@angular/core';
import { AuthHttp } from 'angular2-jwt';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  error = '';
  token: string;
  thing: string;

  constructor(public authHttp: AuthHttp) {}
  ngOnInit() {
  }
  login() {
    this.authHttp.get('http://localhost:8080/auth/login')
      .map(res => res.json())
      .subscribe(
        data => this.thing,
        err => console.log('error'),
        () => console.log('Request Complete')
      );
  }

}
