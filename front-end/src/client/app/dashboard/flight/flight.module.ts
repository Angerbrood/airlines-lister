import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { FlightComponent } from './flight.component';
import { CreateFlightModule} from './create-flight/createFlight.module';
import { DeleteFlightModule} from './delete-flight/deleteFlight.module';
import { ModifyFlightModule} from './modify-flight/modifyFlight.module';
import { ViewFlightModule} from './view-flight/viewFlight.module';

@NgModule({
    imports: [
      CommonModule,
      RouterModule,
      CreateFlightModule,
      DeleteFlightModule,
      ModifyFlightModule,
      ViewFlightModule
    ],
    declarations: [FlightComponent],
    exports: [FlightComponent]
})

export class FlightModule { }
