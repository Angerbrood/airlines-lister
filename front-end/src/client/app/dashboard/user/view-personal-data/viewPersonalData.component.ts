import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'view-personal-data',
    templateUrl: './view-personal-data.component.html'
})

export class ViewPersonalDataComponent {
  private roles : any;
  private id : string;
  private passengerId : string;
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
  private role : any;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    let payLoad = {
      'data' : this._cookieService.get('username')
    };
    _apiService.post('http://localhost:8080/user/getPersonalData', JSON.stringify(payLoad)).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.id = temp.data.id;
      this.ssoId = temp.data.ssoId;
      this.password = temp.data.password;
      this.passengerId = temp.data.userPassengerData.id;
      this.firstname = temp.data.userPassengerData.firstName;
      this.lastname = temp.data.userPassengerData.lastName;
      this.email = temp.data.userPassengerData.email;
      this.age = temp.data.userPassengerData.age;
      this.address = temp.data.userPassengerData.address;
      this.accountNumber = temp.data.userPassengerData.accountNumber;
      this.balance = temp.data.userPassengerData.balance;
      this.dateOfBirth = this.parseDate(temp.data.userPassengerData.dateOfBirth);
      this.roles = temp.data.userProfiles;
    });
  }
  parseDate(value : any) : string {
    let result : string;
    let temp = value.monthValue < 10 ? '0' + value.monthValue : value.monthValue;
    result = value.year + '-' + temp + '-' + value.dayOfMonth;
    return result;
  }
}
