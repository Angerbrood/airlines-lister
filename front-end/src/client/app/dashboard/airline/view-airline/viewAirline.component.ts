import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';

@Component({
	moduleId: module.id,
    selector: 'view-airline',
    templateUrl: './view-airline.component.html'
})

export class ViewAirlineComponent {
  private airlines : any;
  private airlineToView : string;
  private airlineFlights : any;
  constructor(private _apiService:ApiService, private _cookieService:CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listAirlines', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.airlines = temp.data;
      this.airlineToView = temp.data[0].id;
    });
  }
  updateAirlineSelect(value : string) {
    this.airlineToView = value.split(' ')[1];
    let payload = {
      'data' : this.airlineToView
    };
    this._apiService.post('http://localhost:8080/admin/findAirlineById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('view-airline-input')).value = responseData.name;
      this.airlineFlights = responseData.flights;
      console.log(this.airlineFlights);
    });
  }
}
