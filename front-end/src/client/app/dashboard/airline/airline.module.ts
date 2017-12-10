import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { AirlineComponent } from './airline.component';

import { CreateAirlineModule} from './create-airline/createAirline.module';
import { ModifyAirlineModule} from './modify-airline/modifyAirline.module';
import { DeleteAirlineModule} from './delete-airline/deleteAirline.module';
import { ViewAirlineModule} from './view-airline/viewAirline.module';

@NgModule({
    imports: [
      RouterModule,
      CommonModule,
      CreateAirlineModule,
      ModifyAirlineModule,
      DeleteAirlineModule,
      ViewAirlineModule,
    ],
    declarations: [AirlineComponent],
    exports: [AirlineComponent]
})

export class AirlineModule { }
