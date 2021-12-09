import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SearchComponent} from "./components/search/search.component";
import {HttpClientModule} from "@angular/common/http";
import {CarsComponent} from './components/cars/cars.component';
import {RouterModule, Routes} from "@angular/router";


const appRoutes: Routes = [
  {path: 'cars', component: CarsComponent},
  {path: 'search', component: SearchComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    CarsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
