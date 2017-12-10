import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { UserComponent } from './user.component';
import { CreateUserModule} from './create-user/createUser.module';
import { DeleteUserModule} from './delete-user/deleteUser.module';
import { ModifyUserModule} from './modify-user/modifyUser.module';
import { ViewUserModule } from './view-user/viewUser.module';
import { CreateReservationModule}  from './create-reservation/createReservation.module';
import { DeleteReservationModule}  from './delete-reservation/deleteReservation.module';
import { ModifyPersonalDataModule} from './modify-personal-data/modifyPersonalData.module';
import { ViewPersonalDataModule}   from './view-personal-data/viewPersonalData.module';
import { ViewReservationsModule}   from './view-reservations/viewReservations.module';

@NgModule({
    imports: [
      CommonModule,
      RouterModule,
      CreateUserModule,
      DeleteUserModule,
      ModifyUserModule,
      ViewUserModule,
      CreateReservationModule,
      DeleteReservationModule,
      ModifyPersonalDataModule,
      ViewPersonalDataModule,
      ViewReservationsModule
    ],
    declarations: [UserComponent],
    exports: [UserComponent]
})

export class UserModule { }
