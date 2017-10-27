import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AirlineRoutingModule } from './airline-routing.module';
import { AirlineListComponent } from './airline-list/airline-list.component';
import { AirlineCreateComponent } from './airline-create/airline-create.component';

@NgModule({
  imports: [
    CommonModule,
    AirlineRoutingModule
  ],
  declarations: [AirlineListComponent, AirlineCreateComponent]
})
export class AirlineModule { }
