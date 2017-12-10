import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { FormsModule, ReactiveFormsModule }   from '@angular/forms';

import { LoginModule } from './login/login.module';
import { DashboardModule } from './dashboard/dashboard.module';
import { SharedModule } from './shared/shared.module';


import { AirlineModule} from './dashboard/airline/airline.module';
import { FlightModule} from './dashboard/flight/flight.module';
import { LocationModule} from './dashboard/location/location.module';
import { UserModule} from './dashboard/user/user.module';



@NgModule({
	imports: [
		BrowserModule,
		HttpModule,
		RouterModule.forRoot(routes),
		LoginModule,
		DashboardModule,
		SharedModule.forRoot(),
    AirlineModule,
    FlightModule,
    LocationModule,
    UserModule,
    FormsModule,
    ReactiveFormsModule
	],
	declarations: [AppComponent],
	providers: [
    {
		provide: APP_BASE_HREF,
		useValue: '<%= APP_BASE %>'
	}],
	bootstrap: [AppComponent]

})

export class AppModule { }
