import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'delete-user',
    templateUrl: './delete-user.component.html'
})

export class DeleteUserComponent {
  private users : any;
  private selectedUserId : string;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/admin/listUsers', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.users = temp.data;
      this.selectedUserId = this.users[0].id;
    });
  }
  updateSelectedUser(value : string) {
    console.log(value);
    this.selectedUserId = value;
  }
  deleteUser() {
    let payload = {
      'data': this.selectedUserId
    };
    this._apiService.post('http://localhost:8080/admin/deleteUser', JSON.stringify(payload)).subscribe(response => {
      console.log(response);
    });
  }
}
