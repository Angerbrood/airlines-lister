import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'create-location',
    templateUrl: './create-location.component.html'
})

export class CreateLocationComponent {
  private city : string;
  private country : string;
  private errors : any;
  private message : any;
  constructor(private _apiService : ApiService, private _cookieService : CookieService) {}
  createLocation() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    let payload = {
      'name': this.city,
      'country': this.country
    };
    console.log('PAYLOAD' + JSON.stringify(payload));
    this._apiService.post('http://localhost:8080/admin/addNewLocation', JSON.stringify(payload)).subscribe(response => {
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
    return this.city && this.country;
  }
}
