import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SmoothieDetailsComponent } from './smoothie-details/smoothie-details.component';
import { CreateSmoothieComponent } from './create-smoothie/create-smoothie.component';
import { SmoothieListComponent } from './smoothie-list/smoothie-list.component';
import { UpdateSmoothieComponent } from './update-smoothie/update-smoothie.component';

const routes: Routes = [
  { path: '', redirectTo: 'smoothie', pathMatch: 'full' },
  { path: 'smoothies', component: SmoothieListComponent },
  { path: 'add', component: CreateSmoothieComponent },
  { path: 'update/:id', component: UpdateSmoothieComponent },
  { path: 'details/:id', component: SmoothieDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
