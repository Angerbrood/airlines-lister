import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {ApiService} from '../../services/ApiService';
import { ProfilePictureComponent } from './profilePicture.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ProfilePictureComponent],
    exports: [ProfilePictureComponent],
    providers: [ApiService]
})

export class ProfilePictureModule { }
