import { NgModule } from '@angular/core';
import { ModifyPersonalDataComponent } from './modifyPersonalData.component';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ModifyPersonalDataComponent],
    exports: [ModifyPersonalDataComponent],
    providers:[ApiService]
})

export class ModifyPersonalDataModule { }
