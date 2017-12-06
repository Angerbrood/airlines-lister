import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { LocationComponent } from './location.component';
import { CreateLocationModule} from './create-location/createLocation.module';
import { DeleteLocationModule} from './delete-location/deleteLocation.module';
import { ModifyLocationModule} from './modify-location/modifyLocation.module';
import { ViewLocationModule } from './view-location/viewLocation.module';

@NgModule({
    imports: [
      CommonModule,
      RouterModule,
      CreateLocationModule,
      DeleteLocationModule,
      ModifyLocationModule,
      ViewLocationModule
    ],
    declarations: [LocationComponent],
    exports: [LocationComponent]
})

export class LocationModule { }
