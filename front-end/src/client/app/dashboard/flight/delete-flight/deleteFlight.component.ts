import { Component } from '@angular/core';
import {CookieService} from 'angular2-cookie/core';
import {ApiService} from '../../../services/ApiService';

@Component({
	moduleId: module.id,
    selector: 'delete-flight',
    templateUrl: './delete-flight.component.html'
})

export class DeleteFlightComponent {
  private flights:any;
  private flightDoDelete:string;
  private errors : string;
  private message : string;
  constructor(private _cookieService : CookieService, private _apiService : ApiService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listFlights', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp.data);
      this.flights = temp.data;
    });
  }
  updateFlightToDelete(value : string) {
    this.flightDoDelete = value;
  }
  deleteFlight() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'data': this.flightDoDelete
    };
    this._apiService.post('http://localhost:8080/admin/deleteFlight', JSON.stringify(payload)).subscribe(response => {
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
    return this.flightDoDelete;
  }
}
