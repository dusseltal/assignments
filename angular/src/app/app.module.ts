import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSmoothieComponent } from './create-smoothie/create-smoothie.component';
import { SmoothieDetailsComponent } from './smoothie-details/smoothie-details.component';
import { SmoothieListComponent } from './smoothie-list/smoothie-list.component';
import { UpdateSmoothieComponent } from './update-smoothie/update-smoothie.component';

import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [
    AppComponent,
    CreateSmoothieComponent,
    SmoothieDetailsComponent,
    SmoothieListComponent,
    UpdateSmoothieComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
