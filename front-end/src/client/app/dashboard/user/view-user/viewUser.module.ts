import { NgModule } from '@angular/core';

import { ViewUserComponent } from './viewUser.component';
import {CommonModule} from '@angular/common';
import {ApiService} from '../../../services/ApiService';
import {FormsModule} from '@angular/forms';
@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ViewUserComponent],
    exports: [ViewUserComponent],
    providers:[ApiService]
})

export class ViewUserModule { }
