import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'view-location',
    templateUrl: './view-location.component.html'
})

export class ViewLocationComponent {
  private locationToView : any;
  private locations : any;
  constructor(private _apiService : ApiService, private _cookieService : CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listLocations', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.locations = temp.data;
    });
  }
  updateLocation(value : string) {
    this.locationToView = value.split(' ')[1];
    let payload = {
      'data' : this.locationToView
    };
    this._apiService.post('http://localhost:8080/admin/findLocationById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('locationCityName')).value = responseData.name;
      (<HTMLInputElement>document.getElementById('locationCountryName')).value = responseData.country;
    });

  }
}
