import { Component } from '@angular/core';
import {Http, Headers} from '@angular/http';
import { Router } from '@angular/router';
import {CookieService} from 'angular2-cookie/core';

/**
*	This class represents the lazy loaded LoginComponent.
*/

@Component({
	moduleId: module.id,
	selector: 'login-cmp',
	templateUrl: 'login.component.html',
	styleUrls: ['login.css']
})



export class LoginComponent {
  private username: string;
  private password: string;
  private errors : any;
  private message : any;
  private newfirstname : string;
  private newlastname : string;
  private newssoId : string;
  private newpassword : string;
  private newemail : string;
  private newage : string;
  private newaddress : string;
  private newaccountNumber : string;
  private newbalance : string;
  private newdateOfBirth : string;
  private newUserCreation : boolean;
  private clickCounter : number;
  constructor(private http:Http, private router:Router, private cookieService : CookieService) {
    this.newUserCreation = false;
    this.clickCounter = 1;
  }
  login() {
    this.errors = null;
    this.message = null;
    let data = {
      'username': this.username,
      'password': this.password
    };
    let headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    let payload = JSON.stringify(data);
    console.log('PAYLOAD: ' + payload);
    this.http.post('http://localhost:8080/login', payload, {headers : headers}).subscribe(data => {
      console.log(data.json());
      let result = data.json();
      let type = result['data'].includes('ADMIN') || result['data'].includes('USER');
      if(type === true) {
        this.message = 'SUCCESS';
        this.cookieService.put('username', this.username);
        this.cookieService.put('password', this.password);
        this.router.navigate(['dashboard', 'home']);
      } else {
        console.log('Invalid credentials');
        this.errors = 'ERROR: Invalid credentials';
      }
    });
  }
  register() {
    this.clickCounter += 1;
    if((this.clickCounter % 2) === 0) {
      this.newUserCreation = true;
    } else {
      this.newUserCreation = false;
    }
  }
  registerNewUser() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      firstname : this.newfirstname,
      lastname : this.newlastname,
      ssoId : this.newssoId,
      password : this.newpassword,
      email : this.newemail,
      age : this.newage,
      address : this.newaddress,
      accountNumber : this.newaccountNumber,
      balance : this.newbalance,
      dateOfBirth : this.newdateOfBirth,
      role : 'USER'
    };
    let headers: Headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.http.post('http://localhost:8080/registerNewUser', JSON.stringify(payload), {headers : headers}).subscribe(response => {
      let responseData = JSON.parse(response._body);
      let responseEnum = responseData.responseEnum;
      let responseMessage = responseData.message;
      console.log(responseData);
      if(responseEnum === 'SUCCESS') {
        this.message = responseEnum + ': ' + responseMessage;
      } else {
        this.errors = responseEnum + ': ' + responseMessage;
      }
    });
  }
  checkAttributes() {
    return this.newfirstname && this.newlastname && this.newssoId && this.newpassword  &&
      this.newemail && this.newage && this.newaddress && this.newaccountNumber &&
      this.newbalance && this.newdateOfBirth;
  }
}
