import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { CreateFlightComponent } from './createFlight.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [CreateFlightComponent],
    exports: [CreateFlightComponent],
    providers: [ApiService]
})

export class CreateFlightModule { }
