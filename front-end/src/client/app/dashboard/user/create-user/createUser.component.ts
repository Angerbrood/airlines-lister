import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'create-user',
    templateUrl: './create-user.component.html'
})

export class CreateUserComponent {
  private roles : any;
  private firstname : string;
  private lastname : string;
  private ssoId : string;
  private password : string;
  private email : string;
  private age : string;
  private address : string;
  private accountNumber : string;
  private balance : string;
  private dateOfBirth : string;
  private role : string;
  private errors : any;
  private message : any;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/admin/listUserRoles', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.roles = temp.data;
      this.role = temp.data[0].type;
    });
  }
  updateRole(value : string) {
    this.role = value;
  }
  createUser() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      firstname : this.firstname,
      lastname : this.lastname,
      ssoId : this.ssoId,
      password : this.password,
      email : this.email,
      age : this.age,
      address : this.address,
      accountNumber : this.accountNumber,
      balance : this.balance,
      dateOfBirth : this.dateOfBirth,
      role : this.role
    };
    this._apiService.post('http://localhost:8080/admin/createNewUser', JSON.stringify(payload)).subscribe(response => {
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
    return this.firstname && this.lastname && this.ssoId && this.password  &&
      this.email && this.age && this.address && this.accountNumber &&
      this.balance && this.dateOfBirth && this.role;
  }
}
