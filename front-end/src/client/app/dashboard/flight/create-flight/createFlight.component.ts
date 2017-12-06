import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'create-flight',
    templateUrl: './create-flight.component.html'
})

export class CreateFlightComponent {
  private airlines : any;
  private startLocations: any;
  private endLocations : any;
  private flightNumber : string;
  private startDate : string;
  private endDate : string;
  private travellingTime : number;
  private startLocationId : string;
  private endLocationId : string;
  private airlineId : string;
  private errors : any;
  private message : any;

  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
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
  updateStartLocationSelect(value : string) {
    console.log('START ' + value);
    this.startLocationId = value;
  }
  updateEndLocationSelect(value : string) {
    console.log('END ' + value);
    this.endLocationId = value;
  }
  updateFlightAirlineSelect(value : string) {
    console.log('AIRLINE ' + value);
    this.airlineId = value;
  }
  createFlight() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }

    let payload = {
      'airlineId': this.airlineId,
      'number': this.flightNumber,
      'startLocationId': this.startLocationId,
      'endLocationId': this.endLocationId,
      'startDate': this.startDate,
      'endDate': this.endDate,
      'travelingTime': this.travellingTime
    };


    this._apiService.post('http://localhost:8080/admin/addFlight', JSON.stringify(payload))
      .subscribe(response => {
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
      this.endLocationId && this.startDate && this.endDate && this.travellingTime;
  }
}
