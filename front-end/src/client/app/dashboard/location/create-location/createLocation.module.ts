import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CreateLocationComponent } from './createLocation.component';
import {ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';

@NgModule({
    imports: [FormsModule, CommonModule],
    declarations: [CreateLocationComponent],
    exports: [CreateLocationComponent],
    providers: [ApiService]
})

export class CreateLocationModule { }
