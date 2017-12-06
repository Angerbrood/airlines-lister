import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'view-flight',
    templateUrl: './view-flight.component.html'
})

export class ViewFlightComponent {
  private flights:any;
  private flightToView : any;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listFlights', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.flights = temp.data;
    });
  }
  updateFlightToView(value : string) {
    this._apiService.post('http://localhost:8080/user/listFlights', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      let index = value.split(':')[0];
      (<HTMLInputElement>document.getElementById('view-flight-number')).value = temp.data[index].flightNumber;
      (<HTMLInputElement>document.getElementById('view-start-location')).value = temp.data[index].start.country + '-' + temp.data[index].start.name;
      (<HTMLInputElement>document.getElementById('view-end-location')).value = temp.data[index].destination.country + '-' + temp.data[index].destination.name;
      (<HTMLInputElement>document.getElementById('view-start-date-input')).value = this.parseDate(temp.data[index].startDate);
      (<HTMLInputElement>document.getElementById('view-land-date-input')).value = this.parseDate(temp.data[index].landingDate);
      (<HTMLInputElement>document.getElementById('view-traveling-time-input')).value = temp.data[index].travelTime;

    });
  }
  parseDate(value : any) : string {
    let result : string;
    result = value.year + '-' + value.monthValue + '-' + value.dayOfMonth;
    return result;
  }
}
