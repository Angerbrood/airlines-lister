import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ModifyFlightComponent } from './modifyFlight.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ModifyFlightComponent],
    exports: [ModifyFlightComponent],
    providers:[ApiService]
})

export class ModifyFlightModule { }
