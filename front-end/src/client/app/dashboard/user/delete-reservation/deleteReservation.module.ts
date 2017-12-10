import { NgModule } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import { DeleteReservationComponent } from './deleteReservation.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [DeleteReservationComponent],
    exports: [DeleteReservationComponent],
    providers:[ApiService]
})

export class DeleteReservationModule { }
