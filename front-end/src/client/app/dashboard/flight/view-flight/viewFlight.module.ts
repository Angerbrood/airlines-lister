import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ViewFlightComponent } from './viewFlight.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ViewFlightComponent],
    exports: [ViewFlightComponent],
    providers:[ApiService]
})

export class ViewFlightModule { }
