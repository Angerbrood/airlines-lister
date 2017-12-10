import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {ApiService} from '../../../services/ApiService';
import { ModifyUserComponent } from './modifyUser.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ModifyUserComponent],
    exports: [ModifyUserComponent],
    providers: [ApiService]
})

export class ModifyUserModule { }
