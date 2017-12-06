import { Component } from '@angular/core';
import {RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {CookieService} from 'angular2-cookie/core';
import {Http, Headers} from '@angular/http';

@Component({
	moduleId: module.id,
    selector: 'profile-picture',
    templateUrl: './profile-picture.component.html'
})

export class ProfilePictureComponent {
  private username : string;
  private password : string;
  constructor(private http:Http, private cookieService : CookieService) {
    this.username = cookieService.get('username');
    this.password = cookieService.get('password');
  }
  fileChange(event : any) {
    let fileList: FileList = event.target.files;
    if(fileList.length > 0) {
      let file: File = fileList[0];
      let formData:FormData = new FormData();
      formData.append('uploadFile', file, file.name);
      let headers = new Headers();
      headers.append('Authorization', 'Basic ' + btoa(this.username + ':' + this.password));
      headers.append('Content-Type', 'multipart/form-data');
      headers.append('Accept', 'application/json');
      let options = new RequestOptions({ headers: headers });
      this.http.post('http://localhost:8080/user/uploadProfilePicture', formData, options)
        .map(res => res.json())
        .catch(error => Observable.throw(error))
        .subscribe(
          data => console.log('success'),
          error => console.log(error)
        );
    }
  }
}
