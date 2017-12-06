import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ViewLocationComponent } from './viewLocation.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ViewLocationComponent],
    exports: [ViewLocationComponent],
    providers: [ApiService]
})

export class ViewLocationModule { }
