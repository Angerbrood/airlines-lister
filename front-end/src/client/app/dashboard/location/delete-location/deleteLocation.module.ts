import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DeleteLocationComponent } from './deleteLocation.component';
import { ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';


@NgModule({
    imports: [FormsModule, CommonModule],
    declarations: [DeleteLocationComponent],
    exports: [DeleteLocationComponent],
    providers: [ApiService]
})

export class DeleteLocationModule { }
