import { NgModule } from '@angular/core';
import { CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ModifyAirlineComponent } from './modifyAirline.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ModifyAirlineComponent],
    exports: [ModifyAirlineComponent],
    providers:[ApiService]
})

export class ModifyAirlineModule { }
