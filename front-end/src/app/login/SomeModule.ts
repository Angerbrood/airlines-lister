import {AuthHttp, AuthModule} from 'angular2-jwt';
import { LoginComponent} from "./login.component";
import {NgModule} from '@angular/core';

@NgModule({
  imports: [AuthModule],
  declarations: [LoginComponent]
})
export class SomeModule {}
