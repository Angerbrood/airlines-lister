import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';


@Component({
	moduleId: module.id,
    selector: 'delete-airline',
    templateUrl: './delete-airline.component.html'
})

export class DeleteAirlineComponent {
  private airlines : any;
  private airlineToDelete : number;
  private errors : any;
  private message : any;
  constructor(private _apiService : ApiService, private _cookieService : CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listAirlines', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.airlines = temp.data;
      this.airlineToDelete = temp.data[0].id;
    });
  }
  updateAirlineSelect(value : number) {
    this.airlineToDelete = value;
  }
  deleteAirline() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'data': this.airlineToDelete
    };
    this._apiService.post('http://localhost:8080/admin/deleteAirline', JSON.stringify(payload)).subscribe(response => {
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
    return this.airlineToDelete;
  }
}
