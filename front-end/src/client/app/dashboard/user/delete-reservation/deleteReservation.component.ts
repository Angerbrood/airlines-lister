import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'delete-reservation',
    templateUrl: './delete-reservation.component.html'
})

export class DeleteReservationComponent {
  private flights:any;
  private flightId : string;
  private ssoId : string;
  private errors : any;
  private message : any;
  private flightIdToFind : string;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this.ssoId = this._cookieService.get('username');
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listReservations', JSON.stringify({'data':this.ssoId})).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.flights = temp.data;
    });
  }
  updateReservationInfo(value : string) {
    this.flightIdToFind = value.split(' ')[1];
    let payload = {
      'data' : this.flightIdToFind
    };
    this._apiService.post('http://localhost:8080/admin/findFlightById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      this.flightId = responseData.id;
      (<HTMLInputElement>document.getElementById('flight-number')).value = responseData.flightNumber;
      (<HTMLInputElement>document.getElementById('from-location')).value = responseData.start.country + '-' + responseData.start.name;
      (<HTMLInputElement>document.getElementById('to-location')).value = responseData.destination.country + '-' + responseData.destination.name;
      (<HTMLInputElement>document.getElementById('flight-date')).value = this.parseDate(responseData.startDate);
      (<HTMLInputElement>document.getElementById('landing-date')).value = this.parseDate(responseData.landingDate);
      (<HTMLInputElement>document.getElementById('traveling-time-input')).value = responseData.travelTime;

    });
  }
  parseDate(value : any) : string {
    let result : string;
    let temp = value.monthValue < 10 ? '0' + value.monthValue : value.monthValue;
    result = value.year + '-' + temp + '-' + value.dayOfMonth;
    return result;
  }
  deleteReservation() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'flightId': this.flightId,
      'ssoId': this.ssoId
    };
    this._apiService.post('http://localhost:8080/user/deleteReservation', JSON.stringify(payload)).subscribe(response => {
      let responseData = JSON.parse(response._body);
      let responseEnum = responseData.responseEnum;
      console.log(responseData);
      if(responseEnum === 'SUCCESS') {
        this.message = responseEnum;
      } else {
        this.errors = responseEnum;
      }
    });
  }
  checkAttributes() {
    return this.flightId && this.ssoId;
  }
}
