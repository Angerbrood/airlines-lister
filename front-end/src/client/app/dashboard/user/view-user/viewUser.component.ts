import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'view-user',
    templateUrl: './view-user.component.html'
})

export class ViewUserComponent {
  private roles : any;
  private role : string;
  private users : any;
  private userToView : any;
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
    this.userToView = value.split(' ')[1];
    let payload = {
      'data' : this.userToView
    };
    this._apiService.post('http://localhost:8080/admin/findUserById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('view-ssoId')).value = responseData.ssoId;
      (<HTMLInputElement>document.getElementById('view-password')).value= responseData.password;
      (<HTMLInputElement>document.getElementById('view-firstName')).value = responseData.userPassengerData.firstName;
      (<HTMLInputElement>document.getElementById('view-lastName')).value  = responseData.userPassengerData.lastName;
      (<HTMLInputElement>document.getElementById('view-email')).value = responseData.userPassengerData.email;
      (<HTMLInputElement>document.getElementById('view-age')).value = responseData.userPassengerData.age;
      (<HTMLInputElement>document.getElementById('view-address')).value = responseData.userPassengerData.address;
      (<HTMLInputElement>document.getElementById('view-accountNumber')).value = responseData.userPassengerData.accountNumber;
      (<HTMLInputElement>document.getElementById('view-balance')).value = responseData.userPassengerData.balance;
      (<HTMLInputElement>document.getElementById('view-dateOfBirth')).value = this.parseDate(responseData.userPassengerData.dateOfBirth);
      (<HTMLInputElement>document.getElementById('view-profiles')).value = responseData.userProfiles;
    });
  }
  parseDate(value : any) : string {
    let result : string;
    let temp = value.monthValue < 10 ? '0' + value.monthValue : value.monthValue;
    result = value.year + '-' + temp + '-' + value.dayOfMonth;
    return result;
  }
}
