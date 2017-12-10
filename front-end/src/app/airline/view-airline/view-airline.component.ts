import { Component, OnInit } from '@angular/core';
import { webServiceEndpoint} from '../../commons';
import {Http, Response, URLSearchParams, RequestOptions} from '@angular/http';

@Component({
  selector: 'app-view-airline',
  templateUrl: './view-airline.component.html',
  styleUrls: ['./view-airline.component.css']
})
export class ViewAirlineComponent implements OnInit {

  constructor(private http: Http) { }

  ngOnInit() {
    const wrapper = {
      secretKey: 'sanyi',
      data: 'data'
    };

    this.http.get(`${webServiceEndpoint}/user/listAirlines`, JSON.stringify(wrapper)).subscribe();
  }

}
