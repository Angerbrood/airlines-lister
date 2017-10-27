import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AirlineListComponent } from './airline-list/airline-list.component';
import { AirlineCreateComponent } from './airline-create/airline-create.component';

const routes: Routes = [
  {path: 'airline', component: AirlineListComponent},
  {path: 'airline/create', component: AirlineCreateComponent},
  {path: 'airline/edit/:id', component: AirlineCreateComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AirlineRoutingModule { }
