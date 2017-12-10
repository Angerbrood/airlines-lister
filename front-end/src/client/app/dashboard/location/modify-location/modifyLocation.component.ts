import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';


@Component({
	moduleId: module.id,
    selector: 'modify-location',
    templateUrl: './modify-location.component.html'
})

export class ModifyLocationComponent {
  private locations : any;
  private locationToModify: string;
  private id:number;
  private city : string;
  private country : string;
  private errors : any;
  private message : any;
  constructor(private _apiService : ApiService, private _cookieService : CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listLocations', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.locations = temp.data;
      this.locationToModify = temp.data[0].id;
    });
  }
  updateLocation(value : string) {
    this.locationToModify = value.split(' ')[1];
    let payload = {
      'data' : this.locationToModify
    };
    this._apiService.post('http://localhost:8080/admin/findLocationById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('locationCityName')).value = responseData.name;
      (<HTMLInputElement>document.getElementById('locationCountryName')).value = responseData.country;
    });

  }
  modifyLocation() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'id': this.id,
      'name': this.city,
      'country': this.country
    };
    console.log(payload);
    this._apiService.post('http://localhost:8080/admin/updateLocation', JSON.stringify(payload)).subscribe(response => {
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
