import { Route } from '@angular/router';

import { FlightComponent } from './index';
import { CreateFlightRoutes} from './create-flight/createFlight.routes';
import { DeleteFlightRoutes} from './delete-flight/deleteFlight.routes';
import { ModifyFlightRoutes} from './modify-flight/modifyFlight.routes';
import { ViewFlightRoutes} from './view-flight/viewFlight.routes';

export const FlightRoutes: Route[] = [
	{
		path: 'flight',
		component: FlightComponent,
    children: [
      ...CreateFlightRoutes,
      ...DeleteFlightRoutes,
      ...ModifyFlightRoutes,
      ...ViewFlightRoutes
    ]
  }
];
