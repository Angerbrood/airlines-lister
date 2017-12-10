import { Route } from '@angular/router';

import { HomeRoutes } from './home/index';
import { BlankPageRoutes } from './blank-page/index';
import { BSComponentRoutes } from './bs-component/index';

import { DashboardComponent } from './index';

import { AirlineRoutes} from './airline/index';
import { FlightRoutes} from './flight/flight.routes';
import { LocationRoutes} from './location/location.routes';
import { UserRoutes} from './user/user.routes';
import { ProfilePictureRoutes} from '../shared/profile-picture/profilePicture.routes';

export const DashboardRoutes: Route[] = [
  	{
    	path: 'dashboard',
    	component: DashboardComponent,
    	children: [
	    	...HomeRoutes,
	    	...BSComponentRoutes,
	    	...BlankPageRoutes,
        ...AirlineRoutes,
        ...FlightRoutes,
        ...LocationRoutes,
        ...UserRoutes,
        ...ProfilePictureRoutes
    	]
  	}
];
