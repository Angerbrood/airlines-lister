import { Route } from '@angular/router';

import { LocationComponent } from './index';

import { CreateLocationRoutes} from './create-location/createLocation.routes';
import { DeleteLocationRoutes} from './delete-location/deleteLocation.routes';
import { ModifyLocationRoutes} from './modify-location/modifyLocation.routes';
import { ViewLocationRoutes } from './view-location/viewLocation.routes';

export const LocationRoutes: Route[] = [
	{
		path: 'location',
		component: LocationComponent,
    children: [
      ...CreateLocationRoutes,
      ...DeleteLocationRoutes,
      ...ModifyLocationRoutes,
      ...ViewLocationRoutes
    ]
	}
];
