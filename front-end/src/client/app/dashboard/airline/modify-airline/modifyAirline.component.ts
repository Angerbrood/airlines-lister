import { Component } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CookieService} from 'angular2-cookie/core';


@Component({
	moduleId: module.id,
    selector: 'modify-airline',
    templateUrl: './modify-airline.component.html'
})

export class ModifyAirlineComponent {
  private airlines : any;
  private airlineToModify : string;
  private newName : string;
  private errors : any;
  private message : any;
  constructor(private _apiService:ApiService, private _cookieService:CookieService) {
    this._apiService.initService(this._cookieService.get('username'), this._cookieService.get('password'));
    _apiService.post('http://localhost:8080/user/listAirlines', {}).subscribe(response => {
      let temp = JSON.parse(response._body);
      console.log(temp);
      console.log(temp.data);
      this.airlines = temp.data;
      this.airlineToModify = temp.data[0].id;
    });
  }
  updateAirlineSelect(value : string) {
    this.airlineToModify = value.split(' ')[1];
    let payload = {
      'data' : this.airlineToModify
    };
    this._apiService.post('http://localhost:8080/admin/findAirlineById', JSON.stringify(payload)).subscribe(response => {
      let responseBody = JSON.parse(response._body);
      let responseData = responseBody.data;
      (<HTMLInputElement>document.getElementById('modify-airline-input')).value = responseData.name;
    });
  }
  updateAirline() {
    this.errors = null;
    this.message = null;
    if(!this.checkAttributes()) {
      this.errors = 'All input should be filled';
      return;
    }
    let payload = {
      'id' : this.airlineToModify,
      'name':this.newName
    };
    this._apiService.post('http://localhost:8080/admin/updateAirline', JSON.stringify(payload)).subscribe(response => {
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
    return this.airlineToModify && this.newName;
  }
}
