import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../services/ApiService';

@Component({
	moduleId: module.id,
	selector: 'sidebar-cmp',
	templateUrl: 'sidebar.html'
})

export class SidebarComponent {
  showMenu: string = '';
  private username : string;
  private isAdminMenu : boolean;
  private isUserMenu : boolean;
	constructor(private _apiService:ApiService, private router:Router, private _cookieService : CookieService) {
	  this.isAdminMenu = false;
	  this.isUserMenu = false;
	  this.username = _cookieService.get('username');
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    this._apiService.post('http://localhost:8080/user/getUserPermission', JSON.stringify({'data': this.username})).subscribe(response => {
      let responseData = JSON.parse(response._body);
      let responseMessage = responseData.message;
      let type = responseMessage.split(':')[1];
      if(type === 'ADMIN') {
        this.isAdminMenu = true;
      } else {
        this.isUserMenu = true;
      }
    });
  }
	addExpandClass(element: any) {
		if (element === this.showMenu) {
			this.showMenu = '0';
		} else {
			this.showMenu = element;
		}
	}
	logout() {
    this._apiService.post('http://localhost:8080/user/logout', {}).subscribe(response => {
      let responseData = JSON.parse(response._body);
      let responseEnum = responseData.responseEnum;
      console.log(responseData);
      if (responseEnum === 'SUCCESS') {
        this._cookieService.remove('username');
        this._cookieService.remove('password');
        this.router.navigate(['']);
      } else {
        console.log(response);
      }
    });
  }
}
