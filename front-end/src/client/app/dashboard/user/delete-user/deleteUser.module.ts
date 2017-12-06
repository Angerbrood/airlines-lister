import { NgModule } from '@angular/core';

import { DeleteUserComponent } from './deleteUser.component';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {ApiService} from '../../../services/ApiService';

@NgModule({
    imports: [FormsModule, CommonModule],
    declarations: [DeleteUserComponent],
    exports: [DeleteUserComponent],
    providers: [ApiService]
})

export class DeleteUserModule { }
