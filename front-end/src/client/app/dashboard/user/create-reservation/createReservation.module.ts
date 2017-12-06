import { NgModule } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import { CreateReservationComponent } from './createReservation.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [CreateReservationComponent],
    exports: [CreateReservationComponent],
    providers:[ApiService]
})

export class CreateReservationModule {
}
