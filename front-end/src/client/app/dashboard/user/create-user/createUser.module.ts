import { NgModule } from '@angular/core';
import {ApiService} from '../../../services/ApiService';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import { CreateUserComponent } from './createUser.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [CreateUserComponent],
    exports: [CreateUserComponent],
    providers: [ApiService]
})

export class CreateUserModule { }
