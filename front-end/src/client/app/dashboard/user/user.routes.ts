import { Route } from '@angular/router';

import { UserComponent } from './index';
import { CreateUserRoutes} from './create-user/createUser.routes';
import { DeleteUserRoutes} from './delete-user/deleteUser.routes';
import { ModifyUserRoutes} from './modify-user/modifyUser.routes';
import { ViewUserRoutes} from './view-user/viewUser.routes';
import { CreateReservationRoutes}  from './create-reservation/createReservation.routes';
import { DeleteResrvationRoutes}   from './delete-reservation/deleteReservation.routes';
import { ModifyPersonalDataRoutes} from './modify-personal-data/modifyPersonalData.routes';
import { ViewPersonalDataRoutes}   from './view-personal-data/viewPersonalData.routes';
import { ViewReservationsRoutes}   from './view-reservations/viewReservations.routes';

export const UserRoutes: Route[] = [
	{
		path: 'user',
		component: UserComponent,
    children: [
      ...CreateUserRoutes,
      ...DeleteUserRoutes,
      ...ModifyUserRoutes,
      ...ViewUserRoutes,
      ...CreateReservationRoutes,
      ...DeleteResrvationRoutes,
      ...ModifyPersonalDataRoutes,
      ...ViewPersonalDataRoutes,
      ...ViewReservationsRoutes
    ]
	}
];
