import { Component } from '@angular/core';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  cars: Car[];

  constructor() {
    this.cars = [];
  }


}
