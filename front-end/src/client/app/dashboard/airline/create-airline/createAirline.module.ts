import { NgModule } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import { FormsModule } from '@angular/forms';
import { CreateAirlineComponent } from './createAirline.component';
import {CommonModule} from '@angular/common';

@NgModule({
    imports: [FormsModule, CommonModule],
    declarations: [CreateAirlineComponent],
    exports: [CreateAirlineComponent],
    providers: [ApiService]
})

export class CreateAirlineModule { }
