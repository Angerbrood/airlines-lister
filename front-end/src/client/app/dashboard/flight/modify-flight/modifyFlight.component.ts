import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'modify-flight',
    templateUrl: './modify-flight.component.html'
})

export class ModifyFlightComponent {
  private flights: any;
  private flightToModify: string;
  private airlines: any;
  private startLocations: any;
  private endLocations: any;
  private flightNumber: string;
  private startDate: string;
  private endDate: string;
  private travellingTime: number;
  private startLocationId: string;
  private endLocationId: string;
  private airlineId: string;
  private errors : any;
  private message : any;
  constructor(private _cookieService: CookieService, private _apiService: ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listFlights', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.flights = temp.data;
    });
    _apiService.post('http://localhost:8080/user/listAirlines', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.airlines = temp.data;
    });
    _apiService.post('http://localhost:8080/user/listLocations', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.startLocations = temp.data;
      this.endLocations = temp.data;
    });
  }

  updateFlightToModify(value: string) {
    this.flightToModify = value.split(' ')[1];
    let payload = {
      'data' : this.flightToModify
    };
    this._apiService.post('http://localhost:8080//admin/findFlightById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      console.log(responseData);
      (<HTMLInputElement>document.getElementById('flight-number')).value = responseData.flightNumber;
      (<HTMLInputElement>document.getElementById('start-date-input')).value = this.parseDate(responseData.startDate);
      (<HTMLInputElement>document.getElementById('land-date-input')).value = this.parseDate(responseData.landingDate);
      (<HTMLInputElement>document.getElementById('traveling-time-input')).value = responseData.travelTime;
      //(<HTMLInputElement>document.getElementById('start-location-selector'))[index].value = responseData.start;
      //(<HTMLInputElement>document.getElementById('end-location-selector')).value = responseData.destination;

    });
  }
  updateStartLocationSelect(value: string) {
    this.startLocationId = value;
  }

  updateEndLocationSelect(value: string) {
    this.endLocationId = value;
  }

  updateFlightAirlineSelect(value: string) {
    this.airlineId = value;
  }

  updateFlight() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'id': this.flightToModify,
      'airlineId': this.airlineId,
      'number': this.flightNumber,
      'startLocationId': this.startLocationId,
      'endLocationId': this.endLocationId,
      'startDate': this.startDate,
      'endDate': this.endDate,
      'travelingTime': this.travellingTime
    };
    this._apiService.post('http://localhost:8080/admin/updateFlight', JSON.stringify(payload)).subscribe(response => {
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
    return this.airlineId && this.flightNumber && this.startLocationId &&
      this.endLocationId && this.startDate && this.endDate && this.travellingTime && this.flightToModify;
  }
  parseDate(value : any) : string {
    let result : string;
    result = value.year + '-' + value.monthValue + '-' + value.dayOfMonth;
    return result;
  }
}
