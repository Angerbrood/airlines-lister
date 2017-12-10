import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ViewPersonalDataComponent } from './viewPersonalData.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ViewPersonalDataComponent],
    exports: [ViewPersonalDataComponent],
    providers: [ApiService]
})

export class ViewPersonalDataModule { }
