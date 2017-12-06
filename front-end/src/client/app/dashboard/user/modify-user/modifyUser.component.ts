import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'modify-user',
    templateUrl: './modify-user.component.html'
})

export class ModifyUserComponent {
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
  private users : any;
  private userToModify : string;
  private errors : any;
  private message : any;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/admin/listUserRoles', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      this.roles = temp.data;
      this.role = temp.data[0].type;
    });
    _apiService.post('http://localhost:8080/admin/listUsers', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.users = temp.data;
    });
  }
  updateSelectedUser(value : string) {
    this.userToModify = value;
    console.log(this.userToModify);
  }
  updateUserModifyFields(value : string) {
    this.userToModify = value.split(' ')[1];
    let payload = {
      'data' : this.userToModify
    };
    this._apiService.post('http://localhost:8080/admin/findUserById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('ssoId')).value = responseData.ssoId;
      (<HTMLInputElement>document.getElementById('password')).value= responseData.password;
      (<HTMLInputElement>document.getElementById('firstName')).value = responseData.userPassengerData.firstName;
      (<HTMLInputElement>document.getElementById('lastName')).value  = responseData.userPassengerData.lastName;
      (<HTMLInputElement>document.getElementById('email')).value = responseData.userPassengerData.email;
      (<HTMLInputElement>document.getElementById('age')).value = responseData.userPassengerData.age;
      (<HTMLInputElement>document.getElementById('address')).value = responseData.userPassengerData.address;
      (<HTMLInputElement>document.getElementById('accountNumber')).value = responseData.userPassengerData.accountNumber;
      (<HTMLInputElement>document.getElementById('balance')).value = responseData.userPassengerData.balance;
      (<HTMLInputElement>document.getElementById('dateOfBirth')).value = this.parseDate(responseData.userPassengerData.dateOfBirth);
      (<HTMLInputElement>document.getElementById('profiles')).value = responseData.userProfiles;
    });
  }
  updateRole(value : string) {
    this.role = value;
  }
  updateUser() {
    this.errors = null;
    this.message = null;
    let payload = {
      id : this.userToModify,
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
    console.log(payload);
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }

    this._apiService.post('http://localhost:8080/admin/updateNewUser', JSON.stringify(payload)).subscribe(response => {
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
  parseDate(value : any) : string {
    let result : string;
    let temp = value.monthValue < 10 ? '0' + value.monthValue : value.monthValue;
    result = value.year + '-' + temp + '-' + value.dayOfMonth;
    return result;
  }
}
