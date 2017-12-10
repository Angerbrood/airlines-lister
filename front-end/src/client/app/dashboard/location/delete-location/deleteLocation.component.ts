import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'delete-location',
    templateUrl: './delete-location.component.html'
})

export class DeleteLocationComponent {
  private locations : any;
  private locationToDelete: number;
  private errors : any;
  private message : any;
  constructor(private _apiService : ApiService, private _cookieService : CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listLocations', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.locations = temp.data;
      this.locationToDelete = temp.data[0].id;
    });
  }
  updateLocation(value : number) {
    console.log(value);
    this.locationToDelete = value;
  }
  deleteLocation() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'data': this.locationToDelete
    };
    this._apiService.post('http://localhost:8080/admin/deleteLocation', JSON.stringify(payload)).subscribe(response => {
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
    return this.locationToDelete;
  }
}
