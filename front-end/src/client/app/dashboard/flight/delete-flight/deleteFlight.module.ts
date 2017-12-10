import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { DeleteFlightComponent } from './deleteFlight.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [DeleteFlightComponent],
    exports: [DeleteFlightComponent],
    providers:[ApiService]
})

export class DeleteFlightModule { }
