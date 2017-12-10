import { NgModule } from '@angular/core';
import { ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DeleteAirlineComponent } from './deleteAirline.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [DeleteAirlineComponent],
    exports: [DeleteAirlineComponent],
    providers: [ApiService]
})

export class DeleteAirlineModule { }
