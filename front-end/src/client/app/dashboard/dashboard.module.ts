import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HomeModule } from './home/home.module';
import { BlankPageModule } from './blank-page/blankPage.module';
import { BSComponentModule } from './bs-component/bsComponent.module';

import { DashboardComponent } from './dashboard.component';

import { SidebarComponent } from '../shared/index';
import {ProfilePictureModule} from '../shared/profile-picture/profilePicture.module';

@NgModule({
    imports: [
        CommonModule,
    	RouterModule,
    	HomeModule,
    	BSComponentModule,
        BlankPageModule,
      FormsModule,
      ProfilePictureModule
    ],
    declarations: [DashboardComponent, SidebarComponent],
    exports: [DashboardComponent, SidebarComponent]
})

export class DashboardModule { }
