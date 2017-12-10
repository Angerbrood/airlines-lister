import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'create-reservation',
    templateUrl: './create-reservation.component.html'
})

export class CreateReservationComponent {
  private flights:any;
  private flightId : string;
  private ssoId : string;
  private flightIdToFind : string;
  private fromCity : string;
  private toCity : string;
  private errors : any;
  private message : any;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this.ssoId = this._cookieService.get('username');
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
  }
  findFlightsByGiveLocations() {
    this.resetFields();
    if(!this.fromCity && !this.toCity) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'fromCity' : this.fromCity,
      'toCity' : this.toCity
    };
    this._apiService.post('http://localhost:8080//user/findFlightByLocations', JSON.stringify(payload)).subscribe(response => {
      let responseData = JSON.parse(response._body);
      this.flights = responseData.data;
    });
  }

  private resetFields() {
    (<HTMLInputElement>document.getElementById('view-flight-number')).value = '';
    (<HTMLInputElement>document.getElementById('view-start-location')).value = '';
    (<HTMLInputElement>document.getElementById('view-end-location')).value = '';
    (<HTMLInputElement>document.getElementById('view-start-date-input')).value = '';
    (<HTMLInputElement>document.getElementById('view-land-date-input')).value = '';
    (<HTMLInputElement>document.getElementById('view-traveling-time-input')).value = '';
    (<HTMLInputElement>document.getElementById('ticketprice-input')).value = '';
  }
  updateFlightForReservation(value : string) {
    this.flightIdToFind = value.split(' ')[1];
    let payload = {
      'data' : this.flightIdToFind
    };
    this._apiService.post('http://localhost:8080/admin/findFlightById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      this.flightId = responseData.id;
      (<HTMLInputElement>document.getElementById('view-flight-number')).value = responseData.flightNumber;
      (<HTMLInputElement>document.getElementById('view-start-location')).value = responseData.start.country + '-' + responseData.start.name;
      (<HTMLInputElement>document.getElementById('view-end-location')).value = responseData.destination.country + '-' + responseData.destination.name;
      (<HTMLInputElement>document.getElementById('view-start-date-input')).value = this.parseDate(responseData.startDate);
      (<HTMLInputElement>document.getElementById('view-land-date-input')).value = this.parseDate(responseData.landingDate);
      (<HTMLInputElement>document.getElementById('view-traveling-time-input')).value = responseData.travelTime;
      (<HTMLInputElement>document.getElementById('ticketprice-input')).value = responseData.ticketPrice;

    });
  }
  parseDate(value : any) : string {
    let result : string;
    let temp = value.monthValue < 10 ? '0' + value.monthValue : value.monthValue;
    result = value.year + '-' + temp + '-' + value.dayOfMonth;
    return result;
  }
  createReservation() {
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
    this._apiService.post('http://localhost:8080/user/bookFlight', JSON.stringify(payload)).subscribe(response => {
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
    return this.flightId && this.ssoId;
  }
}
