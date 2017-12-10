import { Route } from '@angular/router';

import { AirlineComponent } from './index';
import { CreateAirlineRoutes } from './create-airline/createAirline.routes';
import { ModifyAirlineRoutes } from './modify-airline/modifyAirline.routes';
import { DeleteAirlineRoutes } from './delete-airline/deleteAirline.routes';
import { ViewAirlineRoutes } from './view-airline/viewAirline.routes';
export const AirlineRoutes: Route[] = [
	{
		path: 'airline',
		component: AirlineComponent,
    children: [
      ...CreateAirlineRoutes,
      ...ModifyAirlineRoutes,
      ...DeleteAirlineRoutes,
      ...ViewAirlineRoutes
    ]
	}
];
