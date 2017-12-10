import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ModifyLocationComponent } from './modifyLocation.component';

@NgModule({
    imports: [CommonModule, FormsModule],
    declarations: [ModifyLocationComponent],
    exports: [ModifyLocationComponent]
})

export class ModifyLocationModule { }
