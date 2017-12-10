import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {PersonComponent} from './person/person.component';
import {PersonListComponent} from './person-list/person-list.component';
import {TableElementsCountComponent} from './table-elements-count/table-elements-count.component';
import {TablePaginationComponent} from './table-pagination/table-pagination.component';
import {TableSortComponent} from './table-sort/table-sort.component';
import {PersonService} from './person.service';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { NavigationComponent } from './navigation/navigation.component';
import { CreateAirlineComponent } from './airline/create-airline/create-airline.component';
import { ModifyAirlineComponent } from './airline/modify-airline/modify-airline.component';
import { DeleteAirlineComponent } from './airline/delete-airline/delete-airline.component';
import { ViewAirlineComponent } from './airline/view-airline/view-airline.component';

const appRoutes: Routes = [
   // {path: '', component: PersonListComponent},
  // {path: 'person/:id', component: PersonComponent, resolve: {person: PersonService}}
    {path: '', component: LoginComponent},
    {path: 'home', component: HomeComponent},
    {path: 'home/create-airline', component: CreateAirlineComponent},
    {path: 'home/modify-airline', component: ModifyAirlineComponent},
    {path: 'home/modify-airline', component: ModifyAirlineComponent},
    {path: 'home/delete-airline', component: DeleteAirlineComponent},
    {path: 'home/view-airline', component: ViewAirlineComponent},

];

@NgModule({
    declarations: [
        AppComponent,
        PersonComponent,
        PersonListComponent,
        TableElementsCountComponent,
        TablePaginationComponent,
        TableSortComponent,
        LoginComponent,
        HomeComponent,
        NavigationComponent,
        CreateAirlineComponent,
        ModifyAirlineComponent,
        DeleteAirlineComponent,
        ViewAirlineComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        RouterModule.forRoot(appRoutes)
    ],
    providers: [PersonService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
