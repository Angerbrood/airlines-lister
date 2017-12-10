import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ApiService {
  private username: string;
  private password: string;
  constructor(private _http: Http) {}
  initService(username: string, password: string) {
    this.username = username;
    this.password = password;
  }
  post(url:string, data:any): Observable<any> {
    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ':' + this.password));
    headers.append('Content-Type', 'application/json');
    return this._http.post(url, data, {headers: headers});
  }
  get(url:string) :Observable<any> {
    let headers: Headers = new Headers();
    headers.append('Authorization', 'Basic ' + btoa(this.username + ':' + this.password));
    headers.append('Content-Type', 'application/json');
    return this._http.get(url, {headers: headers});
  }
}
