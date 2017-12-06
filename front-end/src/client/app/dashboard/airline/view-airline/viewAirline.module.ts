import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ViewAirlineComponent } from './viewAirline.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ViewAirlineComponent],
    exports: [ViewAirlineComponent],
    providers: [ApiService]
})

export class ViewAirlineModule { }
